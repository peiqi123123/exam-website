package com.whpu.dao.pojo;

import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:00
 */
@Data
public class StuAnsRecording {
    private String StudentId;
    private String recordingId;
    private String questionId;
    private String stuAnswer;
    private Integer judgment;
}
