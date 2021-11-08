package com.whpu.vo.params;

import lombok.Data;

/**
 * @description，用户登陆时可以提供的内容
 * @author: 唉 烁
 * @time: 2021/10/27 23:37
 */
@Data
public class LoginParam {
    private String account;
    private String password;
    private String nickName;
    private String identity;
}
