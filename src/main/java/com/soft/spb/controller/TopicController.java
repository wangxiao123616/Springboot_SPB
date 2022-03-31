package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicServiceImpl topicServiceImpl;

    @PostMapping("/queryRundomTopicFullList")
    public List<Topic> queryRundomTopicFullList(@RequestBody Topic topic){
        List<Topic> topicList = topicServiceImpl.queryRundomTopicFullList();
        return topicList;
    }

    @PostMapping("/querySearchTopicFullList")
    public List<Topic> querySearchTopicFullList(@RequestBody Topic topic){
        List<Topic> topicList = topicServiceImpl.querySearchTopicFullList(topic.getTopicName());
        return topicList;
    }
    @PostMapping("/querySearchTopicNameList")
    public List<Topic> querySearchTopicNameList(@RequestBody Topic topic) {
        List<Topic> nameList = topicServiceImpl.querySearchTopicNameList(topic.getTopicName());
        return nameList;
    }

    @PostMapping("/queryTopicFull")
    public List<Topic> queryTopicFull(@RequestBody Topic topic){
        List<Topic> topicList = topicServiceImpl.queryTopicFull(topic.getTopicName());
        return topicList;
    }

    @PostMapping("/queryTopicNameList")
    public List<String> queryTopicNameList(){
        List<String> nameList = topicServiceImpl.queryTopicNameList();
        return nameList;
    }


}
