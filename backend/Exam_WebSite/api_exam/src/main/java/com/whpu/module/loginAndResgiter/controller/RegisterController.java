package com.whpu.controller.token;

import com.whpu.service.LoginAndRegisterService;
import com.whpu.vo.ErrorCode;
import com.whpu.vo.Result;
import com.whpu.vo.params.LoginParam;
import com.whpu.vo.params.RegisterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * 这是一个注册的功能，暂时不做，不做
 * @author: 唉 烁
 * @time: 2021/10/28 16:59
 */
@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;
    @PostMapping("student")
    public Result doRegisterStu(@RequestBody RegisterParam registerParam)
    {
        if(registerParam.getAccount()==null||
        registerParam.getNickName()==null||
        registerParam.getPassword()==null)
        {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        return loginAndRegisterService.registerStudent(registerParam);
    }
    @PostMapping("teacher")
    public Result doRegisterTeacher(@RequestBody RegisterParam registerParam)
    {

        if(registerParam.getAccount()==null||
                registerParam.getNickName()==null||
                registerParam.getPassword()==null)
        {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        return loginAndRegisterService.registerTeacher(registerParam);
    }
    @PostMapping("manager")
    public Result doRegisterManager(@RequestBody RegisterParam registerParam)
    {

        if(registerParam.getAccount()==null||
                registerParam.getNickName()==null||
                registerParam.getPassword()==null)
        {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        return loginAndRegisterService.registerManager(registerParam);
    }

}
