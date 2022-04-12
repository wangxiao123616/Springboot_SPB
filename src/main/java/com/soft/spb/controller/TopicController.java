package com.soft.spb.controller;


import com.soft.spb.pojo.dto.TopicInfoDto;
import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.service.TopicService;
import com.soft.spb.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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
    TopicService topicService;

    @PostMapping("/queryRundomTopicFullList")
    public List<Topic> queryRundomTopicFullList(@RequestBody Topic topic){
        List<Topic> topicList = topicService.queryRundomTopicFullList();
        return topicList;
    }

    @GetMapping("/querySearchTopicFullList")
    public List<Topic> querySearchTopicFullList(@Nullable @RequestParam("search") String topic){
        List<Topic> topicList = topicService.querySearchTopicFullList(topic);
        return topicList;
    }

    @PostMapping("/getTopicFull")
    public Topic getTopicFull(@RequestBody TopicInfoDto topicinfo){
        Topic topic = topicService.getTopicFull(topicinfo);
        return topic;
    }

    @PostMapping("/querySearchTopicNameList")
    public List<Topic> querySearchTopicNameList(@RequestBody Topic topic) {
        List<Topic> nameList = topicService.querySearchTopicNameList(topic.getTopicName());
        return nameList;
    }

    @PostMapping("/queryTopicFull")
    public List<Topic> queryTopicFull(@RequestBody Topic topic){
        List<Topic> topicList = topicService.queryTopicFull(topic.getTopicName());
        return topicList;
    }

    @PostMapping("/queryTopicNameList")
    public List<String> queryTopicNameList(){
        List<String> nameList = topicService.queryTopicNameList();
        return nameList;
    }

    @RequestMapping(value = "/queryHotTopicList" ,method = RequestMethod.GET)
    public List<Topic> queryHotTopicList(){
        return topicService.queryHotTopicList();
    }
}
