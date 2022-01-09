package com.whpu.module.user.controller;

import com.whpu.module.exam.service.ExamRecordingService;
import com.whpu.module.user.dao.pojo.SysStu;
import com.whpu.module.user.service.StuTeacherService;
import com.whpu.module.user.service.SysStuService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.GetAllStudentInfoVo;
import com.whpu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/student")
@Transactional
public class StuController {
    @Autowired
    private StuTeacherService stuTeacherService;
    @Autowired
    private SysStuService sysStuService;
    @Autowired
    private ExamRecordingService examRecordingService;
    @GetMapping("getSelfInfo")
    public Result<GetAllStudentInfoVo> getAllStudent() {
        String studentId = UserThreadLocal.get().getUserId();
        SysStu ownStudentInfo = sysStuService.getOwnStudentInfo(studentId);
        return Result.success(ownStudentInfo);
    }
}
