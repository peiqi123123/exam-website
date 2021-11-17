package com.whpu.vo;

import com.whpu.dao.pojo.ChoiceQuestion;

import com.whpu.dao.pojo.TFQuestion;
import lombok.Data;

import java.util.List;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 8:37
 */
@Data
public class ExerciseRandomVo {
    List<ChoiceQuestion> choiceQuestions;
    List<TFQuestion> TFQuestions;
    Integer size;
    String examTime;
    String examId;
    Integer totalPoints;
}
