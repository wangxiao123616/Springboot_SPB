package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TopicMapperTest {

     @Autowired
     private TopicMapper topicMapper;
    @Test
    void queryRundomTopicFullList() {
        List<Topic> topicList = topicMapper.queryRundomTopicFullList(1, 400);
        System.out.println(topicList);
    }
}