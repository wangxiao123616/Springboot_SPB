package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Attentiontopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class AttentiontopicMapperTest {

    @Autowired
    private AttentiontopicMapper attentiontopicMapper;

    @Test
    void getAttentionTopPresenter() {
        attentiontopicMapper.getAttentionTopPresenter("G18190404").forEach(System.out::println);
    }

    @Test
    void queryTopicName() {
        List<String> s = attentiontopicMapper.queryTopicName("G18190403");

        System.out.println(s);
    }

    @Test
    void addAttentionTopic() {
        Attentiontopic attentiontopic = new Attentiontopic();
        attentiontopic.setTopicId(21);
        LocalDateTime localDateTime = LocalDateTime.now();
        attentiontopic.setTopicDate(localDateTime);
        attentiontopic.setUserAccount("q12");
        attentiontopic.setTopicName("加油，冲,就是干");
         attentiontopicMapper.addAttentionTopic(attentiontopic);


    }
}