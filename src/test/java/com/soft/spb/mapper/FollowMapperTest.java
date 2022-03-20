package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Follow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FollowMapperTest {

    @Autowired
    private FollowMapper followMapper;


    @Test
    void getFollow() {
        followMapper.getFollow().forEach(System.out::println);
    }

    @Test
    void addFollow() {
        Follow follow = new Follow();
        follow.setFollowAccount("456");
        follow.setFollowedAccount("123");
        System.out.println(followMapper.addFollow(follow));

    }

    @Test
    void deleteFollow(){
        followMapper.deleteFollow("567","123");
    }
}