package com.whpu.vo;

import com.whpu.module.exam.dao.pojo.ExamRecording;
import lombok.Data;

import java.util.List;

@Data
public class GetExamRecordingInfo {
    private List<ExamRecording> allExamRecording;
}
