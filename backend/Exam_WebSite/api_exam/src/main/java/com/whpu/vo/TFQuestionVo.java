package com.whpu.vo;

import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 16:16
 */
@Data
public class TFQuestionVo {
    private String questionId;
    private String questionContent;
    private String analyse;
    private Integer answer;
    private String stuAnswer;
    private Integer score = 1;
    private String status;
}
