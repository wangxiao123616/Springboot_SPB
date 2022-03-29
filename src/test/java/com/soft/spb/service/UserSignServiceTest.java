package com.soft.spb.service;

import com.soft.spb.service.impl.UserSignServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSignServiceTest {

    @Autowired
    private UserSignServiceImpl userSignServiceImpl;


    @Test
    void testQueryUserBadge() {
        System.out.println(userSignServiceImpl.queryUserBadge("G18190406"));
//        UserSign userSign = new UserSign();
//        userSign.setUserAccount("G18190406");
        //List<UserSign> signList = userSignServiceImpl.queryUserBadge(userSign);
       // System.out.println(signList);
    }
}