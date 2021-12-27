package com.whpu.module.loginAndResgiter.controller;

import com.whpu.module.loginAndResgiter.service.LoginAndRegisterService;
import com.whpu.vo.Result;
import com.whpu.vo.TokenVo;
import com.whpu.vo.params.LoginParam;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/27 23:32
 */
@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private LoginAndRegisterService loginService;

    @PostMapping
    public Result<TokenVo> doLogin(@ApiParam("这是登录参数") @RequestBody LoginParam loginParam)
    {
        return loginService.doLogin(loginParam);
    }
}
