package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserMapperTest {

    @Autowired
    PasswordEncoder pas;
    @Test
    void updateUserPersonalInformation() {
        System.out.println(pas.encode("1"));
    }


}