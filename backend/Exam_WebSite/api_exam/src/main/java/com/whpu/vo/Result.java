package com.whpu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:统一的返回数据类
 * @author: 唉 烁
 * @time: 2021/10/27 21:46
 */
@Data
@AllArgsConstructor
public class Result {
    private boolean success;

    private int code;//返回状态码

    private String msg; //返回的信息

    private Object data; //返回的数据

    public static Result success(Object data)
    {
        return new Result(true,201,"success",data);
    }

    public static Result fail(int code,String msg)
    {
        return new Result(false,code,msg,null);
    }
}
