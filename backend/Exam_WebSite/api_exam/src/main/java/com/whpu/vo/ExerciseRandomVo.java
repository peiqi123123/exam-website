package com.whpu.vo;

import com.whpu.dao.pojo.SysQuestion;

import lombok.Data;

import java.util.List;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 8:37
 */
@Data
public class ExerciseRandomVo {
    List<QuestionVo> SysQuestions;
    Integer size;
    String examTime;
    String examId;
    Integer totalPoints;
}
