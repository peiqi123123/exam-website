package com.whpu.service;

import com.whpu.dao.pojo.User;
import com.whpu.vo.Result;
import com.whpu.vo.params.LoginParam;

public interface LoginAndRegisterService {
    Result doLogin(LoginParam loginParam);

    Result checkToken(String token);

    /**
     * @description: 退出登录
     * @param token
     * @return: com.whpu.vo.Result
     */
    Result doLogout(String token);

    Result register(LoginParam loginParam);

}
