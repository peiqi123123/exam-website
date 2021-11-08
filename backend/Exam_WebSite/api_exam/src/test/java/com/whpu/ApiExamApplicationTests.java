package com.whpu;

import com.whpu.dao.pojo.User;
import com.whpu.service.Impl.UserServiceImpl;
import com.whpu.service.QuestionService;
import com.whpu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Service;

@SpringBootTest
class ApiExamApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Test
    void contextLoads() {
    }
    @Test
    public void testDb()
    {
        User user= new User();
        user.setAccount("123456");
        user.setPassword("123456");
        user.setNickName("小明");
        userService.addUser(user);
    }

    @Test
    public void addTestQuestion()
    {
        for (int i = 0; i <999 ; i++) {
            questionService.addTestQuestion();
        }
    }
}
