package com.soft.spb.service;

import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.service.impl.FollowServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void queryFollowAccount() {
    }

    @Test
    void queryFollowList() {
        Follow follow = new Follow();
        follow.setFollowedAccount("G18190404");
        System.out.println(followServiceImpl.queryFollowList(follow)+"查询成功");
    }

    @Test
    void queryFollowedCount() {
        Follow follow = new Follow();
        follow.setFollowedAccount("G18190403");
        System.out.println(followServiceImpl.queryFollowedCount(follow));
    }

    @Test
    void queryFollowedList() {
        Follow follow   = new Follow();
        follow.setFollowedAccount("G18190403");
        System.out.println(followServiceImpl.queryFollowedList(follow));
    }

    @Test
    void queryFollowUserList() {
        //System.out.println( followServiceImpl.queryFollowUserList("G18190403"));

    }

    @Test
    void queryFollowedUserList() {
        //System.out.println(followServiceImpl.queryFollowedUserList("G18190404"));

    }
}