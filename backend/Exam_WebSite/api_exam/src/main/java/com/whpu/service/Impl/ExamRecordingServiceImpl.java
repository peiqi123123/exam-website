package com.whpu.service.Impl;

import com.whpu.dao.mapper.ExamRecordingMapper;
import com.whpu.dao.pojo.ExamRecording;
import com.whpu.service.ExamRecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于添加考试的记录
 */
@Service
public class ExamRecordingServiceImpl implements ExamRecordingService {
    @Autowired
    ExamRecordingMapper examRecordingMapper;
    /**
     * 创建一条考试记录，一般用于在考生开始考试的时候
     */
    @Override
    public String addExamRecordingService() {
        ExamRecording examRecording = new ExamRecording();
        examRecordingMapper.insert(examRecording);
        return examRecording.getRecordingId();
    }
}
