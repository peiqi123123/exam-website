package com.whpu.controller;

import com.whpu.service.QuestionService;
import com.whpu.utils.JWTUtils;
import com.whpu.vo.QuestionVo;
import com.whpu.vo.Result;
import com.whpu.vo.params.RandomParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/30 13:22
 */
@RestController
@RequestMapping("api/exercise")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @PostMapping("random")
    public Result selectRandomQuestion(@RequestBody RandomParam randomParam,@RequestHeader String token)
    {
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        Object userId = stringObjectMap.get("userId");
        Map<String,Object> res = questionService.selectRandomQuestion(randomParam.getQuestionNum(),(String)userId);
        return Result.success(res);
    }
}
