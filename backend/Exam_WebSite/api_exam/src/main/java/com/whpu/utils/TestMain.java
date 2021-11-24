package com.whpu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/23 19:47
 */
public class TestMain {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String date = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(date);
    }
}
