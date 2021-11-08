package com.whpu.controller;

import com.whpu.service.LoginAndRegisterService;
import com.whpu.vo.Result;
import com.whpu.vo.params.LoginParam;
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
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;
    @PostMapping
    public Result doRegister(@RequestBody LoginParam loginParam)
    {
        return loginAndRegisterService.register(loginParam);
    }
}
