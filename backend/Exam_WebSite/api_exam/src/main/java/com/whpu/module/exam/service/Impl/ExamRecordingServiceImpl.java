package com.whpu.module.exam.service.Impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whpu.module.exam.dao.mapper.ExamRecordingMapper;
import com.whpu.module.exam.dao.pojo.ExamRecording;
import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.loginAndResgiter.dao.pojo.User;
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
    public String addExamRecordingService(Integer questionNum,String examType) {
        ExamRecording examRecording = new ExamRecording();
        User user = UserThreadLocal.get();
        examRecording.setStudentId(/*user.getUserId()*/"1463502680960798722");
        examRecording.setQuestionNum(questionNum);
        examRecording.setExamType(examType);
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
        System.out.println(studentId);
        return list;
    }
}
