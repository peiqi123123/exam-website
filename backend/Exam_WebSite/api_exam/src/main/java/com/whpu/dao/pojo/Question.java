package com.whpu.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/29 20:03
 */
@Data
public class Question  {
    @TableId(value = "questionId",type = IdType.ID_WORKER_STR)
    String questionId;

    @TableField(value = "AnsNum")
    Integer AnsNum;

    @TableField(value = "questionContent")
    String questionContent;

    @TableField(value = "optionA")
    String optionA;

    @TableField(value = "optionB")
    String optionB;

    @TableField(value = "optionC")
    String optionC;

    @TableField(value = "optionD")
    String optionD;

    @TableField(value = "optionE")
    String optionE;

    @TableField(value = "optionF")
    String optionF;

    @TableField(value = "optionG")
    String optionG;

    @TableField(value = "Answer")
    String Answer;

    @TableField(value = "Analyse")
    String Analyse;
}
