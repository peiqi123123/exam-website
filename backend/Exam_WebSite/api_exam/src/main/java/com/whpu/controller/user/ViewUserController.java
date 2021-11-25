package com.whpu.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whpu.dao.pojo.User;
import com.whpu.service.UserService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/23 14:50
 */
@RestController
@RequestMapping("api/view")
public class ViewUserController {
    @Autowired
   private UserService userService;
    @RequestMapping("student/{currentPage}/{size}")
    public Result viewStudent(@PathVariable("currentPage")int currentPage,
                              @PathVariable("size") int size)
    {
        User user = UserThreadLocal.get();
        IPage<User> userIPage = userService.selectStudentInfo(currentPage, size,user.getUserId());
        return Result.success(userIPage);
    }
}
