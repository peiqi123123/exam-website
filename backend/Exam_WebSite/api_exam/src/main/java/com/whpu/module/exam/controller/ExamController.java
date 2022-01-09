package com.whpu.module.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whpu.module.exam.dao.pojo.ExamRecording;
import com.whpu.module.loginAndResgiter.dao.pojo.User;
import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.exam.service.StuAnsRecordingService;
import com.whpu.module.exam.service.StuSubmitService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ExamInfoVo;
import com.whpu.vo.GetExamRecordingInfo;
import com.whpu.vo.Result;
import com.whpu.vo.params.ExamRecordingPageParam;
import com.whpu.vo.params.SubmitParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:06
 */
@RestController
@RequestMapping("api/exercise")
public class ExamController {
    @Autowired
    private StuSubmitService stuSubmitService;
    @Autowired
    private StuAnsRecordingService stuAnsRecordingService;
    @Autowired
    private ExamRecordingService examRecordingService;
    @PostMapping("/submit")
    public Result doSubmit(@RequestBody SubmitParam submitParam)
    {
        User user = UserThreadLocal.get();
        System.out.println(submitParam);
        Result result = stuSubmitService.submit(submitParam,user.getUserId());
        return result;
    }
    @GetMapping("/question/info/{id}")
    public Result<ExamInfoVo> getExamInfo(@PathVariable String id)
    {

        ExamInfoVo examInfo = stuAnsRecordingService.getExamInfo(id);
        return Result.success(examInfo);
    }
    @GetMapping("/exam/info")
    public Result<List<ExamRecording>> getAllExamRecording(@RequestBody ExamRecordingPageParam examRecordingPageParam)
    {
        //如果未给出 当前页面数，就默认是1
        if(examRecordingPageParam.getCurrentPage()==null)
        {
            examRecordingPageParam.setCurrentPage(1);
        }
        //如果当前分页数未给出，就默认是8
        if(examRecordingPageParam.getPageSize()==null)
        {
            examRecordingPageParam.setCurrentPage(8);
        }
        User user = UserThreadLocal.get();
        IPage<ExamRecording> allExamRecording = examRecordingService.getAllExamRecording(user.getUserId(),examRecordingPageParam.getPageSize(),examRecordingPageParam.getCurrentPage());

        GetExamRecordingInfo getExamRecordingInfo = new GetExamRecordingInfo();
        getExamRecordingInfo.setAllExamRecording(allExamRecording);
        return Result.success(getExamRecordingInfo);
    }

}
