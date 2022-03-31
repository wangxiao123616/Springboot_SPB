package com.soft.spb.service;

import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.service.impl.PostbarCommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostbarCommentServiceTest {
    @Autowired
    private PostbarCommentServiceImpl postbarCommentServiceImpl;

    @Test
    void deleteComment() {
        PostbarComment postbarComment = new PostbarComment();
        postbarComment.setCommentId(1);
        postbarComment.setPbOneId("q1");
        postbarCommentServiceImpl.deleteComment(postbarComment);
    }
}