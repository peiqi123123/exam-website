package com.whpu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.whpu.dao.mapper.QuestionMapper;
import com.whpu.dao.pojo.Question;
import com.whpu.service.QuestionService;
import com.whpu.vo.QuestionVo;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/29 20:25
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;


    @Override
    /**
     * 用于添加随机的题目，随机的题目仅用于测试
     */
    public int addTestQuestion() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);
        int res = a+b;
        Question question = new Question();
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
    public Map<String, List<QuestionVo>> selectRandomQuestion(int QuestionNum) {
        LambdaQueryWrapper<Question> qw = new LambdaQueryWrapper<>();
        qw.select(Question::getQuestionContent,Question::getAnalyse,Question::getAnsNum,
                Question::getOptionA,Question::getOptionB,Question::getOptionC,Question::getOptionD,Question::getOptionE
        ,Question::getOptionF,Question::getOptionG,Question::getAnswer,Question::getQuestionId);
        qw.last("ORDER BY RAND() LIMIT "+QuestionNum);
        List<Question> questions = questionMapper.selectList(qw);
        List<QuestionVo> choiceQuestions = new ArrayList<>();
        HashMap<String, List<QuestionVo>> res = new HashMap<>();
        for(Question q:questions)
        {
            QuestionVo a = new QuestionVo();
            a.setQuestionContent(q.getQuestionContent());
            a.setAnalyse(q.getAnalyse());
            a.setAnsNum(q.getAnsNum());
            a.setAnswer(q.getAnswer());
            a.setQuestionId(q.getQuestionId());
            a.setOptionA(q.getOptionA());
            a.setOptionB(q.getOptionB());
            a.setOptionC(q.getOptionC());
            a.setOptionD(q.getOptionD());
            a.setOptionE(q.getOptionE());
            a.setOptionF(q.getOptionF());
            a.setOptionG(q.getOptionG());
            choiceQuestions.add(a);
        }
        res.put("choiceQuestions", choiceQuestions);
        return res;
        }

}
