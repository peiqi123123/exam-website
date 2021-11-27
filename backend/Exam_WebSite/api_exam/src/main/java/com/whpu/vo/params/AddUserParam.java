package com.whpu.vo.params;

import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/23 14:35
 */
@Data
public class AddUserParam {
    private String account;
    private String password;
    private String nickName;
    private String identity;
}
