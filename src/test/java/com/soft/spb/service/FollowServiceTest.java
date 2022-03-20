package com.soft.spb.service;

import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.service.impl.FollowServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FollowServiceTest {


    @Autowired
    private FollowServiceImpl followServiceImpl;

    @Test
    void isFollowed() {
        Follow follow = new Follow();
        follow.setFollowedAccount("123");
        follow.setFollowAccount("456");
        System.out.println(followServiceImpl.isFollowed(follow));
    }

    @Test
    void deleteFollow() {
        Follow follow = new Follow();
        follow.setFollowAccount("456");
        follow.setFollowedAccount("123");

        System.out.println( followServiceImpl.deleteFollow(follow)+"删除成功");
    }
}