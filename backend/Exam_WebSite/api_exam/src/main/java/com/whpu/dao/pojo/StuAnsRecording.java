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
    private String recordingId;
    private String questionId;
    private String stuAnswer;
    private Integer judgment;
}
