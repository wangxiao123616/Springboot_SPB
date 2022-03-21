package com.soft.spb;

import com.soft.spb.service.impl.PostbarlistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpbApplicationTests {
    @Autowired
    private PostbarlistServiceImpl postbarlistServiceImpl;
    @Test
    void contextLoads() {

    }

}
