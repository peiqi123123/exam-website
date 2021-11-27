package com.whpu.service;


import com.whpu.dao.pojo.SysQuestion;
import com.whpu.vo.ExerciseRandomVo;

import java.util.List;
import java.util.Map;

public interface SysQuestionService {

    int addTestSysQuestion();

    ExerciseRandomVo selectRandomQuestion(int QuestionNum, String userId);
}
