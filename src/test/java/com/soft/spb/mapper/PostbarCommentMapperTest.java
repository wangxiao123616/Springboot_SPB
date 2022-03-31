package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostbarCommentMapperTest {

    @Autowired
    private  PostbarCommentMapper postbarCommentMapper;

    @Test
    void deleteComment() {
        postbarCommentMapper.deleteComment(2,"qw212");
    }

//    @Test
//    void deleteComment() {
//        int count = postbarCommentMapper.deleteComment(1, "12qw");
//        System.out.println(count);
//
//    }
}