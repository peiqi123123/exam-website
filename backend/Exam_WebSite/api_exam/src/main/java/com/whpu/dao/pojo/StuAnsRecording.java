package com.whpu.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:00
 */
@Data
public class StuAnsRecording {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String StudentId;
    private String examRecordingId;
    private String questionId;
    private String stuAnswer;
    private String answer;
    private Integer judgment;
    //考试类型，如果是判断题就是0，选择题就是1，默认是-1
    private Integer questionType;


}
