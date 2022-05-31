package com.whpu.module.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whpu.module.exam.dao.pojo.ExamRecording;
import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.exam.service.StuAnsRecordingService;
import com.whpu.module.exam.service.StuSubmitService;
import com.whpu.module.loginAndResgiter.dao.pojo.User;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ExamInfoVo;
import com.whpu.vo.GetExamRecordingInfo;
import com.whpu.vo.Result;
import com.whpu.vo.params.SubmitParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:06
 */
@RestController
@RequestMapping("api/exercise")
@Api(tags = "用于考试的提交，与试卷信息查询")
public class ExamController {
    @Autowired
    private StuSubmitService stuSubmitService;
    @Autowired
    private StuAnsRecordingService stuAnsRecordingService;
    @Autowired
    private ExamRecordingService examRecordingService;

    @ApiOperation(value = "试卷提交的接口")
    @PostMapping("/submit")
    public Result doSubmit(@RequestBody SubmitParam submitParam) {
        User user = UserThreadLocal.get();
        System.out.println(submitParam);
        Result result = stuSubmitService.submit(submitParam, user.getUserId());
        return result;
    }

    @ApiOperation(value = "获取某个试卷信息的接口")
    @GetMapping("/question/info/{id}")
    public Result<ExamInfoVo> getExamInfo(@PathVariable String id) {

        ExamInfoVo examInfo = stuAnsRecordingService.getExamInfo(id);
        return Result.success(examInfo);
    }

    @ApiOperation(value = "获取首页所有考试记录的接口")
    @GetMapping("/exam/info/{pageSize}/{currentPage}")
    public Result<GetExamRecordingInfo> getAllExamRecording(@PathVariable("pageSize") int pageSize, @PathVariable("currentPage") int currentPage) {
        /*if (examRecordingPageParam == null) {
            examRecordingPageParam = new ExamRecordingPageParam();
        }
        //如果未给出 当前页面数，就默认是1
        if (examRecordingPageParam.getCurrentPage() == null) {
            examRecordingPageParam.setCurrentPage(1);
        }
        //如果当前分页数未给出，就默认是8
        if (examRecordingPageParam.getPageSize() == null) {
            examRecordingPageParam.setPageSize(8);
        }*/
        User user = UserThreadLocal.get();
        IPage<ExamRecording> allExamRecording = examRecordingService.getAllExamRecording(user.getUserId(), pageSize, currentPage);

        GetExamRecordingInfo getExamRecordingInfo = new GetExamRecordingInfo();
        getExamRecordingInfo.setAllExamRecording(allExamRecording);
        return Result.success(getExamRecordingInfo);
    }

}
