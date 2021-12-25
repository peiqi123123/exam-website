package com.whpu.module.question.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("question_topics")
public class QuestionTopics {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "topic")
    private String topic;
}
