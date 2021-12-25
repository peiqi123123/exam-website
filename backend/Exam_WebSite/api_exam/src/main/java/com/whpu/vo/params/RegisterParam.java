package com.whpu.vo.params;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class RegisterParam {

    private String account;

    private String password;

    private String nickName;


    //用户状态码，正常是1，禁用是0，默认是1
    private String userState;

    //用户备注
    private String remark;
}
