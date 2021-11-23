package com.whpu.controller.token;

import com.whpu.service.LoginAndRegisterService;
import com.whpu.vo.Result;
import com.whpu.vo.params.LoginParam;
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
    public Result doLogin(@RequestBody LoginParam loginParam)
    {
        return loginService.doLogin(loginParam);
    }
}
