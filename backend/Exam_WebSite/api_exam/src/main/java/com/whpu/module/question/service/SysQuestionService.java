package com.whpu.module.question.service;


import com.whpu.vo.ExerciseRandomVo;
import com.whpu.vo.params.QuestionParam;

public interface SysQuestionService {

   int addSysQuestion(QuestionParam questionParam);
    ExerciseRandomVo selectRandomQuestion(int QuestionNum, String userId);
}
