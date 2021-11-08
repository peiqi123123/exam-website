package com.whpu.controller;

import com.whpu.service.QuestionService;
import com.whpu.vo.QuestionVo;
import com.whpu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("Random")
    public Result selectRandomQuestion(@RequestParam Integer QuestionNum)
    {
        List<QuestionVo> questionVos = questionService.selectRandomQuestion(QuestionNum);
        return Result.success(questionVos);
    }
}
