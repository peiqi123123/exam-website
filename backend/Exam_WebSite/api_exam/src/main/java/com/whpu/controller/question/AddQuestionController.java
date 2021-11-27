package com.whpu.controller.question;

import com.whpu.dao.pojo.TeacherSelfQuestion;
import com.whpu.service.SysQuestionService;
import com.whpu.service.TeacherSelfQuestionService;
import com.whpu.vo.Result;
import com.whpu.vo.params.QuestionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/24 11:19
 */
@RestController
@RequestMapping("api/addQuestion")
public class AddQuestionController {
    @Autowired
    private TeacherSelfQuestionService teacherSelfQuestionService;
    @Autowired
    private SysQuestionService sysQuestionService;
     @RequestMapping("addSelfQuestion")
    public Result addTeacherSelfQuestion(@RequestBody QuestionParam questionParam)
     {
         teacherSelfQuestionService.addQuestion(questionParam);
         return Result.success(null);
     }
    @RequestMapping("addSysQuestion")
    public Result addSysQuestion(@RequestBody QuestionParam questionParam)
    {
        return null;
    }
}