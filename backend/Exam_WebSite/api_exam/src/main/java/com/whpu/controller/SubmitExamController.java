package com.whpu.controller;

import com.whpu.service.Impl.StuSubmitServiceImpl;
import com.whpu.service.StuSubmitService;
import com.whpu.utils.JWTUtils;
import com.whpu.vo.Result;
import com.whpu.vo.params.SubmitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:06
 */
@RestController
@RequestMapping("api/exercise")
public class SubmitExamController {
    @Autowired
    private StuSubmitService stuSubmitService;
    @PostMapping("submit")
    public Result doSubmit(@RequestHeader("Authorization")String token,@RequestBody SubmitParam submitParam)
    {
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        Object userId = stringObjectMap.get("userId");
        Result result = stuSubmitService.submit(submitParam,(String)userId);
        return result;
    }

}
