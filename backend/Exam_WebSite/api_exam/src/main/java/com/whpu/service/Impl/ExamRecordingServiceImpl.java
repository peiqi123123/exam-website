package com.whpu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whpu.dao.mapper.ExamRecordingMapper;
import com.whpu.dao.pojo.ExamRecording;
import com.whpu.service.ExamRecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return examRecording.getExamRecordingId();
    }
    @Override
    public List<ExamRecording> getAllExamRecording(String studentId)
    {
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq("studentId",studentId);
        lambdaQueryWrapper.orderByDesc("submitTime");
        List list = examRecordingMapper.selectList(lambdaQueryWrapper);
        return list;
    }
}
