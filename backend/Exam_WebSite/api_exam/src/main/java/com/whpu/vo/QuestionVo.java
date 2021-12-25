package com.whpu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.whpu.module.question.dao.pojo.QuestionTopics;
import lombok.Data;

import java.util.List;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/30 13:08
 */
@Data
public class QuestionVo {
    public QuestionVo() {
    }

    public QuestionVo(String questionId, String questionContent, int ansNum, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, String optionG, String answer, String analyse, String stuAnswer, Integer status, Integer score, List<QuestionTopics> questionTopics) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        AnsNum = ansNum;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.optionF = optionF;
        this.optionG = optionG;
        Answer = answer;
        Analyse = analyse;
        this.stuAnswer = stuAnswer;
        this.status = status;
        this.score = score;
        this.questionTopics = questionTopics;
    }

    private String questionId;
   private String questionContent;
   private int AnsNum;
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
    private List<QuestionTopics> questionTopics;
    private Integer score=1;
}
