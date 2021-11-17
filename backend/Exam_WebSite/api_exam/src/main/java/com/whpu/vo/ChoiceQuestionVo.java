package com.whpu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/30 13:08
 */
@Data
public class ChoiceQuestionVo {
   private String questionId;
   private String questionContent;
   private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String optionF;
    private String optionG;
    private String Answer;
    private String Analyse;
    private String stuAnswer;
    private Integer status;
    private Integer score=1;
}
