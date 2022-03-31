package com.whpu.module.user.controller;

import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.user.dao.pojo.SysStu;
import com.whpu.module.user.service.StuTeacherService;
import com.whpu.module.user.service.SysStuService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.GetAllStudentInfoVo;
import com.whpu.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
@Transactional
@Api(tags = "学生自有操作的接口")
public class StuController {
    @Autowired
    private SysStuService sysStuService;

    @ApiOperation(value = "获取到自己的个人信息")
    @GetMapping("/getSelfInfo")
    public Result<GetAllStudentInfoVo> getAllStudent() {
        String studentId = UserThreadLocal.get().getUserId();
        SysStu ownStudentInfo = sysStuService.getOwnStudentInfo(studentId);
        return Result.success(ownStudentInfo);
    }
}
