package com.soft.spb.service.impl;

import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersServiceImplTest {

    @Autowired
    private UsersService usersService;

    @Test
    void login() throws ServiceException {
        System.out.println(usersService.login(
                UserDto.builder()
                        .userAccount("G18190406")
                        .password("11111111")
                        .build()
        ));
    }

    @Test
    void register() throws ServiceException {
        System.out.println(usersService.register(
                UserDto.builder()
                        .userAccount("G18190408")
                        .password("11111111")
                        .build()
        ));
    }
}