package com.whpu.controller.user;

import com.whpu.vo.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/24 22:42
 */
@RestController
@RequestMapping("api/update")
public class UpdateUserPassword {
    @RequestMapping("Student/{id}")
    public Result updateStudent(@PathVariable String StudentId)
    {
        return null;
    }

}
