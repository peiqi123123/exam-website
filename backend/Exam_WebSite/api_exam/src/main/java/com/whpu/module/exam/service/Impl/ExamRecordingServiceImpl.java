package com.whpu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whpu.dao.mapper.ExamRecordingMapper;
import com.whpu.dao.pojo.ExamRecording;
import com.whpu.dao.pojo.User;
import com.whpu.service.ExamRecordingService;
import com.whpu.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用于添加考试的记录
 */
@Service
@Transactional
public class ExamRecordingServiceImpl implements ExamRecordingService {
    @Autowired
    ExamRecordingMapper examRecordingMapper;
    /**
     * 创建一条考试记录，一般用于在考生开始考试的时候
     */
    @Override
    public String addExamRecordingService(Integer questionNum) {
        ExamRecording examRecording = new ExamRecording();
        User user = UserThreadLocal.get();
        examRecording.setStudentId(user.getUserId());
        examRecording.setQuestionNum(questionNum);
        examRecordingMapper.insert(examRecording);
        return examRecording.getExamRecordingId();
    }
    @Override
    public List<ExamRecording> getAllExamRecording(String studentId)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("studentId",studentId);
        queryWrapper.orderByDesc("submitTime");
        List<ExamRecording>list = examRecordingMapper.selectList(queryWrapper);
        return list;
    }
}
