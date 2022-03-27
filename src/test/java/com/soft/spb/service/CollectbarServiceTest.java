package com.soft.spb.service;

import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.service.impl.CollectbarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class CollectbarServiceTest {

    @Autowired
    private CollectbarServiceImpl collectbarServiceImpl;
    @Test
    void addCollectBar() {
        Collectbar collectbar = new Collectbar();
        collectbar.setUserAccount("小王");
        collectbar.setPbOneId("w1233");
        collectbarServiceImpl.addCollectBar(collectbar);


    }

    @Test
    void queryCollectBarList() {



    }
}