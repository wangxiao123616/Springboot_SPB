package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Follow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void queryFollowAccount() {

//        followMapper.queryFollowAccount().forEach(System.out::println);
             for(Follow data : followMapper.queryFollowAccount("followedAccount")){
                 System.out.println(data);
             }
    }

    @Test
    void queryFollowList() {
        for (Follow data:  followMapper.queryFollowList("G18190403")
             ) {
            System.out.println(data);
        }
             
    }

    @Test
    void queryFollowedCount() {
        for (Follow data :  followMapper.queryFollowAccount("G18190403")
             ) {
            System.out.println(data);
        }
    }

    @Test
    void queryFollowedList() {
        for (Follow data : followMapper.queryFollowedList("G18190404")
             ) {
            System.out.println(data);
        }
    }
}