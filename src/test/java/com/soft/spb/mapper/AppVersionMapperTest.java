package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppVersionMapperTest {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Test
    void getAppVersion() {
        System.out.println(appVersionMapper.getAppVersion());
    }
}