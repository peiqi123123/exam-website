package com.whpu.utils;

import com.whpu.module.question.dao.mapper.SysQuestionTopicsMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/23 19:47
 */
public class TestMain {

    @Test
    public void test01(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String date = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
    }
    @Test
    public void test02()
    {

    }
}
