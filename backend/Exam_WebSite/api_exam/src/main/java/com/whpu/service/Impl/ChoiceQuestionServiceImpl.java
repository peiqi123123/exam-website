package com.whpu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.whpu.dao.mapper.QuestionMapper;
import com.whpu.dao.mapper.StuAnsRecordingMapper;
import com.whpu.dao.pojo.ChoiceQuestion;
import com.whpu.dao.pojo.StuAnsRecording;
import com.whpu.service.ChoiceQuestionService;
import com.whpu.service.ExamRecordingService;
import com.whpu.vo.ChoiceQuestionVo;
import com.whpu.vo.ExerciseRandomVo;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/29 20:25
 */
@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ExamRecordingService examRecordingService;
    @Autowired
    private StuAnsRecordingMapper stuAnsRecordingMapper;
    @Override
    /**
     * 用于添加随机的题目，随机的题目仅用于测试
     */
    public int addTestChoiceQuestion() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);
        int res = a+b;
        ChoiceQuestion question = new ChoiceQuestion();
        int [] r = new int[4];
        int resIndex = random.nextInt(4);
        r[resIndex] = res;
        for (int i = 0; i <4 ; i++) {
            if(r[i]==0)
            {
                r[i]=res-15+random.nextInt(10);
            }
        }
        question.setQuestionContent(a+"+"+b+"=?");
        question.setOptionA(String.valueOf(r[0]));
        question.setOptionB(String.valueOf(r[1]));
        question.setOptionC(String.valueOf(r[2]));
        question.setOptionD(String.valueOf(r[3]));
        question.setAnswer(String.valueOf(res));
        question.setAnalyse(a+"+"+b+"="+res);
        int insert = questionMapper.insert(question);
        return insert;
    }

    @Override
    @Transactional
    public ExerciseRandomVo selectRandomQuestion(int choiceQuestionNum,String userId) {
        //添加考试的记录
        String examRecordingId = examRecordingService.addExamRecordingService();
        //选择题模块
        if(choiceQuestionNum==0)
        {
            choiceQuestionNum=100;
        }
        //随机查到对应的选择题题目
        LambdaQueryWrapper<ChoiceQuestion> qw = new LambdaQueryWrapper<>();
        qw.select(ChoiceQuestion::getQuestionContent,ChoiceQuestion::getAnalyse,ChoiceQuestion::getAnsNum,
                ChoiceQuestion::getOptionA,ChoiceQuestion::getOptionB,ChoiceQuestion::getOptionC,ChoiceQuestion::getOptionD,ChoiceQuestion::getOptionE
        ,ChoiceQuestion::getOptionF,ChoiceQuestion::getOptionG,ChoiceQuestion::getAnswer,ChoiceQuestion::getQuestionId);
        qw.last("ORDER BY RAND() LIMIT "+choiceQuestionNum);
        List<ChoiceQuestion> choiceQuestions = questionMapper.selectList(qw);


        HashMap<String,Object> res = new HashMap<>();
        for(ChoiceQuestion q:choiceQuestions)
        {

            //将选出来的题发给前端的同时，将对应的题目给个记录
            StuAnsRecording stuAnsRecording = new StuAnsRecording();
            stuAnsRecording.setQuestionId(q.getQuestionId());
            stuAnsRecording.setExamRecordingId(examRecordingId);
            stuAnsRecording.setStudentId(userId);
            stuAnsRecording.setAnswer(q.getAnswer());
            stuAnsRecording.setQuestionType(1);
            stuAnsRecordingMapper.insert(stuAnsRecording);
        }


        ExerciseRandomVo exerciseRandomVo = new ExerciseRandomVo();
            //将选择题目放入到结果集当中
        exerciseRandomVo.setChoiceQuestions(choiceQuestions);
            //判断题模块(还没做)
        exerciseRandomVo.setTFQuestions(null);
            //告诉你这是哪次考试
        exerciseRandomVo.setExamId(examRecordingId);
            //题目数量，如果前端没给就默认100
        exerciseRandomVo.setSize(choiceQuestionNum);
            //考试时长，默认给120分钟，7200秒
        exerciseRandomVo.setExamTime("7200");
            //考试总分，默认给100分
        exerciseRandomVo.setTotalPoints(100);
        return exerciseRandomVo;
        }

}
