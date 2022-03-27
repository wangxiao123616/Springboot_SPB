package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired
  private   UserMapper userMapper;

    @Test
    void deleteUserIp() {
        System.out.println(userMapper.deleteUserIp("xiaowei"));
    }
}