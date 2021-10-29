package com.whpu.utils;

import com.whpu.vo.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/29 9:13
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/doInterceptor")
    public Result dotest()
    {
        return Result.fail(111,"拦截失败");
    }
}
