package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class UserMapperTest {

    @Autowired
  private   UserMapper userMapper;

    @Test
    void deleteUserIp() {
        System.out.println(userMapper.deleteUserIp("xiaowei"));
    }

    @Test
    void updateUserPersonalInformation() {

       User user = new User();
        user.setUserName("张三");
        LocalDate date = LocalDate.of(1999,12,15);

        user.setUserBirth(date);
        user.setUserFavorite("王者");
        user.setUserHome("江苏");
        user.setUserProfile("哈哈");
        user.setUserAccount("wang");
  userMapper.updateUserPersonalInformation(user);

    }
}