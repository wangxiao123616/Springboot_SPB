package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.UserSign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserSignMapperTest {
    @Autowired
    private UserSignMapper userSignMapper;
    @Test
    void queryUserBadge() {
        List<UserSign> signs = userSignMapper.queryUserBadge("G18190405");
        System.out.println(signs);
    }

    @Test
    void queryUserSign() {

        System.out.println(userSignMapper.queryUserSign("G18190403"));
    }
}