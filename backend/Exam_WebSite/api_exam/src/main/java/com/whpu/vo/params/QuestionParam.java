package com.whpu.vo.params;

import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/24 10:52
 */
@Data
public class QuestionParam {
    private String questionContent;
    private Integer AnsNum;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String optionF;
    private String optionG;
    private String Answer;
    private String Analyse;
}
