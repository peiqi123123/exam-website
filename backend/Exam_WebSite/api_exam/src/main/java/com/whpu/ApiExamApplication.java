package com.whpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApiExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiExamApplication.class, args);
    }

}
