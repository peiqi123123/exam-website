package com.whpu.vo;

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
    Long spendTime;//秒
    Long submitTime;
    Integer totalPoints;
    ArrayList<QuestionVo> questions;
    String examId;
    ArrayList<AnsParam> questionAnswers;
}
