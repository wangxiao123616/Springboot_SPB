package com.soft.spb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppVersionMapperTest {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Test
    void getAppVersion() {
        System.out.println(appVersionMapper.getAppVersion().getClass());
    }
}