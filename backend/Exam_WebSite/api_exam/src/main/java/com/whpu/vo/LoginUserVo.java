package com.whpu.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @description 用户信息返回的包装类
 * @author: 唉 烁
 * @time: 2021/10/28 15:57
 */
@Data
public class LoginUserVo {

    //用户账号
    private String account;

    //用户密码
    private String userId;

    //用户昵称
    private String nickName;
}
