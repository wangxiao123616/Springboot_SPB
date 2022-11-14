package com.soft.spb;

import com.soft.spb.service.impl.PostbarlistServiceImpl;
import com.soft.spb.util.AesUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpbApplicationTests {

    @Test
    void contextLoads() {
        try {
            System.out.println(AesUtil.aesDecrypt("HgaNndnw4VbfTlt8Kzy3UA=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
