package com.soft.spb.service;

import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.service.impl.AttentiontopicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootTest
class AttentiontopicServiceTest {
    @Autowired
    AttentiontopicServiceImpl attentiontopicServiceImpl;

    @Test
    void addAttentionTopic() {
        PasswordEncoder pas = new BCryptPasswordEncoder();
        System.out.println(pas.encode("G72IZGCCcBXl1gXtRCUiUQ"));
    }


    @Test
    void testAddAttentionTopic() {
        Attentiontopic attentiontopic = new Attentiontopic();
        attentiontopic.setTopicId(12);
        attentiontopic.setTopicName("jia有");
        attentiontopic.setUserAccount("张三");
        LocalDateTime localDateTime = LocalDateTime.of(2022,3,3,12,00,00);
        attentiontopic.setTopicDate(localDateTime);
        //Integer count = attentiontopicServiceImpl.addAttentionTopic(attentiontopic);
       // System.out.println(count);

        //  attentiontopicServiceImpl.addAttentionTopic("122", 12, "加油", "2022-3-3 12:00:00");



    }


    @Test
    void queryAttentionTopic() {
//        Attentiontopic attentiontopic = new Attentiontopic();
//        attentiontopic.setUserAccount("G18190405");
//        LocalDateTime localDateTime = LocalDateTime.of(2022,5,3,12,00,00);
//        attentiontopic.setTopicDate(localDateTime);
//        List<Attentiontopic> list = attentiontopicServiceImpl.queryAttentionTopic(attentiontopic);
//        System.out.println(list);
    }
}