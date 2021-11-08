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
public class QuestionVo {
    String questionId;

    Integer AnsNum;

    String questionContent;

    String optionA;

    String optionB;

    String optionC;

    String optionD;

    String optionE;

    String optionF;

    String optionG;

    String Answer;

    String Analyse;
}
