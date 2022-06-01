package com.whpu.module.exam.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.module.exam.dao.mapper.ExamRecordingMapper;
import com.whpu.module.exam.dao.pojo.ExamRecording;
import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.loginAndResgiter.dao.pojo.User;
import com.whpu.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @CacheEvict(value = "examRecordsCache", allEntries = true)  //清除缓存
    public String addExamRecordingService(Integer questionNum, String examType) {
        ExamRecording examRecording = new ExamRecording();
        User user = UserThreadLocal.get();
        examRecording.setStudentId(user.getUserId());
        examRecording.setQuestionNum(questionNum);
        examRecording.setExamType(examType);
        examRecordingMapper.insert(examRecording);
        return examRecording.getExamRecordingId();
    }

    @Override
    @Cacheable(value = "examRecordsCache", key = "#studentId + '_allExamRecords'+'_'+#pageSize+'_'+#currentPage")
    public IPage<ExamRecording> getAllExamRecording(String studentId, Integer pageSize, Integer currentPage) {
        IPage<ExamRecording> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        QueryWrapper<ExamRecording> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentId", studentId);
        queryWrapper.orderByDesc("submitTime");
        IPage<ExamRecording> iPage = examRecordingMapper.selectPage(page, queryWrapper);
        System.out.println(studentId);
        return iPage;
    }
}
