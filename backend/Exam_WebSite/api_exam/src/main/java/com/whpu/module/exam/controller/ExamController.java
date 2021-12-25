package com.whpu.module.exam.controller;

import com.whpu.module.exam.dao.pojo.ExamRecording;
import com.whpu.module.loginAndResgiter.dao.pojo.User;
import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.exam.service.StuAnsRecordingService;
import com.whpu.module.exam.service.StuSubmitService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ExamInfoVo;
import com.whpu.vo.Result;
import com.whpu.vo.params.SubmitParam;
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
    public Result getExamInfo(@PathVariable String id)
    {

        ExamInfoVo examInfo = stuAnsRecordingService.getExamInfo(id);
        return Result.success(examInfo);
    }
    @RequestMapping("/exam/info")
    public Result getAllExamRecording()
    {
        User user = UserThreadLocal.get();
        List<ExamRecording> allExamRecording = examRecordingService.getAllExamRecording(user.getUserId());
        return Result.success(allExamRecording);
    }

}
