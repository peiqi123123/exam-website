package com.whpu.service.Impl;

import com.whpu.dao.mapper.TeacherSelfQuestionMapper;
import com.whpu.dao.pojo.TeacherSelfQuestion;
import com.whpu.dao.pojo.User;
import com.whpu.service.TeacherSelfQuestionService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.params.QuestionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/24 11:27
 */
@Service
public class TeacherSelfQuestionServiceImpl implements TeacherSelfQuestionService {
    @Autowired
    private TeacherSelfQuestionMapper teacherSelfQuestionMapper;
    public int addQuestion(QuestionParam questionParam)
    {
        User user = UserThreadLocal.get();
        TeacherSelfQuestion teacherSelfQuestion = new TeacherSelfQuestion(
                questionParam.getAnsNum(),
                questionParam.getQuestionContent(),
                questionParam.getOptionA(),
                questionParam.getOptionB(),
                questionParam.getOptionC(),
                questionParam.getOptionD(),
                questionParam.getOptionE(),
                questionParam.getOptionF(),
                questionParam.getOptionG(),
                questionParam.getAnswer(),
                questionParam.getAnalyse(),
                user.getUserId()
        );
        int insert = teacherSelfQuestionMapper.insert(teacherSelfQuestion);
        return  insert;
    }
}
