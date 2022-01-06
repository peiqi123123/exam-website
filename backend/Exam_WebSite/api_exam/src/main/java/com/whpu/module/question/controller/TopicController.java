package com.whpu.module.question.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whpu.module.question.dao.mapper.QuestionTopicsMapper;
import com.whpu.module.question.dao.mapper.SysQuestionTopicsMapper;
import com.whpu.module.question.dao.pojo.QuestionTopics;
import com.whpu.module.question.dao.pojo.SysQuestionTopic;
import com.whpu.vo.params.TopicParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api/topic")
public class TopicController {
    @Autowired
    private QuestionTopicsMapper questionTopicsMapper;
    @PostMapping("add")
    public void addTopic(@RequestBody TopicParam topicParam)
    {
        QuestionTopics questionTopics = new QuestionTopics();
        questionTopics.setTopic(topicParam.getTopic());
        questionTopicsMapper.insert(questionTopics);
    }
    @GetMapping("remove/{id}")
    public void deleteTopic(@PathVariable Integer id)
    {
        questionTopicsMapper.deleteById(id);
    }
    @GetMapping("change/{id}/{topic}")
    public void deleteTopic(@PathVariable Integer id,@PathVariable String topic )
    {
        questionTopicsMapper.updateById(new QuestionTopics(id,topic));
    }
    @GetMapping("getAllTopic")
    public void getAllTopic()
    {
        questionTopicsMapper.selectList(new QueryWrapper<>());
    }
}
