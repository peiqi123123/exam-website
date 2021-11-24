package com.whpu.vo;

import com.whpu.dao.pojo.SysQuestion;
import com.whpu.dao.pojo.StuAnsRecording;
import com.whpu.vo.params.AnsParam;
import lombok.Data;

import java.util.ArrayList;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 10:22
 */
@Data
public class ExamInfoVo {
    Integer size;
    Integer examTime;//秒
    Integer totalPoints;
    ArrayList<QuestionVo> SysQuestions;
    String examId;
    ArrayList<AnsParam> questionAnswers;
}
