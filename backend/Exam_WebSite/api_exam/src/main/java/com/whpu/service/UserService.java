package com.whpu.service;

import com.whpu.dao.pojo.User;
import com.whpu.vo.Result;

public interface UserService {
    User findUser(String account,String password);

    Integer addUser(User user);

    Result findUserByToken(String token);

    Result selectAllStudentInfo(String token);
}
