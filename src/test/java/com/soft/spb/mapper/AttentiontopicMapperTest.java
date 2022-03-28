package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttentiontopicMapperTest {

    @Autowired
    private AttentiontopicMapper attentiontopicMapper;

    @Test
    void getAttentionTopPresenter() {
        attentiontopicMapper.getAttentionTopPresenter("G18190404").forEach(System.out::println);
    }
}