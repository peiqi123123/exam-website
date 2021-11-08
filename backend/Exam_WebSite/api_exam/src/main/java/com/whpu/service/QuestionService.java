package com.whpu.service;


import com.whpu.dao.pojo.Question;
import com.whpu.vo.QuestionVo;

import java.util.List;

public interface QuestionService {

    int addTestQuestion();

    List<QuestionVo> selectRandomQuestion(int QuestionNum);
}
