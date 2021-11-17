package com.whpu.service;


import com.whpu.dao.pojo.ChoiceQuestion;
import com.whpu.vo.ChoiceQuestionVo;
import com.whpu.vo.ExerciseRandomVo;

import java.util.List;
import java.util.Map;

public interface ChoiceQuestionService {

    int addTestChoiceQuestion();

    ExerciseRandomVo selectRandomQuestion(int QuestionNum, String userId);
}
