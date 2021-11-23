package com.whpu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whpu.dao.mapper.ChoiceQuestionMapper;
import com.whpu.dao.mapper.ExamRecordingMapper;
import com.whpu.dao.mapper.StuAnsRecordingMapper;
import com.whpu.dao.mapper.TFQuestionMapper;
import com.whpu.dao.pojo.ChoiceQuestion;
import com.whpu.dao.pojo.ExamRecording;
import com.whpu.dao.pojo.StuAnsRecording;
import com.whpu.dao.pojo.TFQuestion;
import com.whpu.service.StuAnsRecordingService;
import com.whpu.vo.ChoiceQuestionVo;
import com.whpu.vo.ExamInfoVo;
import com.whpu.vo.TFQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 10:10
 */
@Service
public class StuAnsRecordingServiceImpl implements StuAnsRecordingService {
    @Autowired
    StuAnsRecordingMapper stuAnsRecordingMapper;
    @Autowired
    ExamRecordingMapper examRecordingMapper;
    @Autowired
    ChoiceQuestionMapper choicequestionMapper;
    @Autowired
    TFQuestionMapper tfQuestionMapper;
    @Override
    public ExamInfoVo getExamInfo(String examId) {
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq("examRecordingId",examId);
        List<StuAnsRecording> recordings = stuAnsRecordingMapper.selectList(lambdaQueryWrapper);

        ExamRecording examRecording = examRecordingMapper.selectById(examId);

        ArrayList<TFQuestionVo> tFQuestionsList = new ArrayList<>();
        ArrayList<ChoiceQuestionVo> choiceQuestionsList = new ArrayList<>();
       recordings.forEach(s->
       {
           if(s.getQuestionType()==1)//选择题
           {
                ChoiceQuestionVo choiceQuestionVo = new ChoiceQuestionVo();
               ChoiceQuestion choiceQuestion = choicequestionMapper.selectById(s.getQuestionId());
               choiceQuestionVo.setQuestionId(choiceQuestion.getQuestionId());
               choiceQuestionVo.setAnalyse(choiceQuestion.getAnalyse());
               choiceQuestionVo.setQuestionContent(choiceQuestion.getQuestionContent());
               choiceQuestionVo.setOptionA(choiceQuestion.getOptionA());
               choiceQuestionVo.setOptionB(choiceQuestion.getOptionB());
               choiceQuestionVo.setOptionC(choiceQuestion.getOptionC());
               choiceQuestionVo.setOptionD(choiceQuestion.getOptionD());
               choiceQuestionVo.setOptionE(choiceQuestion.getOptionE());
               choiceQuestionVo.setOptionF(choiceQuestion.getOptionF());
               choiceQuestionVo.setAnswer(choiceQuestion.getAnswer());
               choiceQuestionVo.setStuAnswer(s.getStuAnswer());
               choiceQuestionsList.add(choiceQuestionVo);
           }
           else if(s.getQuestionType()==0)
           {
               TFQuestionVo tfQuestionVo = new TFQuestionVo();
               TFQuestion tfQuestion = tfQuestionMapper.selectById(s.getQuestionId());
               tfQuestionVo.setAnalyse(tfQuestion.getAnalyse());
               tfQuestionVo.setAnswer(tfQuestion.getAnswer());
               tfQuestionVo.setQuestionContent(tfQuestion.getQuestionContent());
               tfQuestionVo.setQuestionId(s.getQuestionId());
               tfQuestionVo.setStuAnswer(s.getStuAnswer());

               tFQuestionsList.add(tfQuestionVo);
           }

       });
        ExamInfoVo examInfoVo = new ExamInfoVo();
        examInfoVo.setChoiceQuestions(choiceQuestionsList);
        examInfoVo.setTFQuestions(tFQuestionsList);
        examInfoVo.setExamId(examId);
        examInfoVo.setExamTime(examRecording.getTotalTime());
        examInfoVo.setSize(examRecording.getQuestionNum());
        examInfoVo.setTotalPoints(examRecording.getTotalScore());
       return examInfoVo;
    }
}
