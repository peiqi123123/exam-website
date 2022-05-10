package com.whpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.whpu.module.*.dao.mapper")
@EnableCaching  //开启缓存注解功能
public class ApiExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiExamApplication.class, args);
    }

}
