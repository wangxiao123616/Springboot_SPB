package com.soft.spb.controller;


import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.service.impl.AttentiontopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
@RequestMapping("/attentiontopic")
public class AttentiontopicController {

    @Autowired
    AttentiontopicServiceImpl attentiontopicServiceImpl;

    @PostMapping("/addAttentionTopic")
    public Integer addAttentionTopic(@RequestBody Attentiontopic attentiontopic){

        LocalDateTime localDateTime =  LocalDateTime.now();
        attentiontopic.setTopicDate(localDateTime);

        Integer count = attentiontopicServiceImpl.addAttentionTopic(attentiontopic);
        return count;
    }

    @PostMapping("/deleteAttentionTopicById")
    public Integer deleteAttentionTopicById(@RequestBody Attentiontopic attentiontopic){
        Integer count = attentiontopicServiceImpl.deleteAttentionTopicById(attentiontopic);
        return  count;
    }

    @PostMapping("/queryAttentionTopic")
    public List<Attentiontopic> queryAttentionTopic(@RequestBody AttentiontopicDto attentiontopicDto){

        List<Attentiontopic> list = attentiontopicServiceImpl.queryAttentionTopic(attentiontopicDto.getUserAccount(),attentiontopicDto.getTopicDate());
     return list;
    }



}
