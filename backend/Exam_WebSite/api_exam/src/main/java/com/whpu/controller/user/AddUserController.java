package com.whpu.controller.user;

import com.whpu.dao.pojo.User;
import com.whpu.service.UserService;
import com.whpu.utils.UserThreadLocal;
import com.whpu.vo.ErrorCode;
import com.whpu.vo.Result;
import com.whpu.vo.params.AddUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/23 14:19
 */
@RestController
@RequestMapping("api/add")
public class AddUserController {
    @Autowired
    private UserService userService;
    @RequestMapping("teacher")
    public Result addTeacher(AddUserParam addUserParam)
    {
        //如果参数是空就报错
        if(addUserParam.getAccount()==null||addUserParam.getNickName()==null||addUserParam.getPassword()==null)
        {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        User user = new User();
        user.setIdentity("Teacher");
        //if(("Manager").equals(UserThreadLocal.get().getIdentity()))
        {
            user.setAccount(addUserParam.getAccount());
            user.setPassword(addUserParam.getPassword());
            user.setNickName(addUserParam.getNickName());
            userService.addUser(user);
        }
        return Result.success(user);
    }
    @RequestMapping("student")
    public Result addStudent(AddUserParam addUserParam)
    {
        //如果参数是空就报错
        if(addUserParam.getAccount()==null||addUserParam.getNickName()==null||addUserParam.getPassword()==null)
        {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        User user = new User();
        user.setIdentity("Student");
        if(("Manager").equals(UserThreadLocal.get().getIdentity())||("Teacher").equals(UserThreadLocal.get().getIdentity()))
        {
            user.setAccount(addUserParam.getAccount());
            user.setPassword(addUserParam.getPassword());
            user.setNickName(addUserParam.getNickName());
            userService.addUser(user);
        }
        return Result.success(user);
    }
}
