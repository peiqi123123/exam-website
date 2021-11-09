package com.whpu.service;


import com.whpu.dao.pojo.Question;
import com.whpu.vo.QuestionVo;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    int addTestQuestion();

    Map<String,Object> selectRandomQuestion(int QuestionNum,String userId);
}
