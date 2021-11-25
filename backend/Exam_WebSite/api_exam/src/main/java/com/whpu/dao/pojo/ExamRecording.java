package com.whpu.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:50
 */
@Data
@TableName("stu_exam_recording")
public class ExamRecording {
    @TableId(type = IdType.ID_WORKER_STR)
    private String examRecordingId;
    private String studentId;
    private Integer questionNum;
    private Integer totalScore;
    private Integer wrongAnsNum;
    private Integer availability;
    private Integer isFinish;
    private String examType;
    private Integer spendTime;
    private String submitTime;
    private Long limitTime;
}
