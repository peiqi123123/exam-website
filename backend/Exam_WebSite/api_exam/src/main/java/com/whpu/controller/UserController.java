package com.whpu.controller;

import com.whpu.service.UserService;
import com.whpu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/28 15:37
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("currentUser")
    public Result currentUser(@RequestHeader String token)
    {
        return userService.findUserByToken(token);
    }
}
