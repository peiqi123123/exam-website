package com.whpu.controller;

import com.whpu.dao.pojo.ExamRecording;
import com.whpu.dao.pojo.StuAnsRecording;
import com.whpu.dao.pojo.User;
import com.whpu.service.ExamRecordingService;
import com.whpu.service.Impl.StuSubmitServiceImpl;
import com.whpu.service.StuAnsRecordingService;
import com.whpu.service.StuSubmitService;
import com.whpu.utils.JWTUtils;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ExamInfoVo;
import com.whpu.vo.Result;
import com.whpu.vo.params.SubmitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:06
 */
@RestController
@RequestMapping("api")
public class ExamController {
    @Autowired
    private StuSubmitService stuSubmitService;
    @Autowired
    private StuAnsRecordingService stuAnsRecordingService;
    @Autowired
    private ExamRecordingService examRecordingService;
    @PostMapping("/exercise/submit")
    public Result doSubmit(@RequestBody SubmitParam submitParam)
    {
        User user = UserThreadLocal.get();
        Result result = stuSubmitService.submit(submitParam,user.getUserId());
        return result;
    }
    @GetMapping("info/exercise/{id}")
    public Result getExamInfo(@PathVariable String id)
    {

        ExamInfoVo examInfo = stuAnsRecordingService.getExamInfo(id);
        return Result.success(examInfo);
    }
    @RequestMapping("getAllExamRecording")
    public Result getAllExamRecording()
    {
        User user = UserThreadLocal.get();
        List<ExamRecording> allExamRecording = examRecordingService.getAllExamRecording(user.getUserId());
        return Result.success(allExamRecording);
    }

}
