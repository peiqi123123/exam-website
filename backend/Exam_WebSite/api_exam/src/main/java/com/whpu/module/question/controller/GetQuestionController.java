package com.whpu.module.question.controller;

import com.whpu.module.loginAndResgiter.dao.pojo.User;
import com.whpu.module.question.service.SysQuestionService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ExerciseRandomVo;
import com.whpu.vo.Result;
import com.whpu.vo.params.RandomParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/30 13:22
 */
@RestController
@RequestMapping("api/exercise")
public class GetQuestionController {

    @Autowired
    SysQuestionService SysQuestionService;
    @PostMapping("random")
    public Result selectRandomQuestion(@RequestBody RandomParam randomParam)
    {
        User user = UserThreadLocal.get();
        ExerciseRandomVo exerciseRandomVo = SysQuestionService.selectRandomQuestion(randomParam.getQuestionNum(), user.getUserId());
        return Result.success(exerciseRandomVo);
    }

}
