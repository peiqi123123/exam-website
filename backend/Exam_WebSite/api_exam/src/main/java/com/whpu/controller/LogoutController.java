package com.whpu.controller;

import com.whpu.service.LoginAndRegisterService;
import com.whpu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/28 16:52
 */
@RestController
@RequestMapping("logout")
public class LogoutController {

    @Autowired
    private LoginAndRegisterService loginService;
    @GetMapping
    public Result doLogout(@RequestHeader("Authorization")String token)
    {
        return loginService.doLogout(token);
    }
}
