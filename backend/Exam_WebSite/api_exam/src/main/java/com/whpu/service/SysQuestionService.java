package com.whpu.service;


import com.whpu.dao.pojo.SysQuestion;
import com.whpu.vo.ExerciseRandomVo;
import com.whpu.vo.params.QuestionParam;

import java.util.List;
import java.util.Map;

public interface SysQuestionService {

    int addTestSysQuestion();

   int addSysQuestion(QuestionParam questionParam);
    ExerciseRandomVo selectRandomQuestion(int QuestionNum, String userId);
}
