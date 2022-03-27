package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Collectbar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CollectbarMapperTest {
    @Autowired
    private   CollectbarMapper collectbarMapper;
    @Test
    void addCollectBar() {
        Collectbar collectbar = new Collectbar();
        collectbar.setUserAccount("张三");
        collectbar.setPbOneId("w1233");
        int i = collectbarMapper.addCollectBar(collectbar);

    }

    @Test
    void deleteCollectBar() {
        Collectbar collectbar = new Collectbar();
        collectbar.setUserAccount("张三");
        collectbar.setPbOneId("w1233");
        int i = collectbarMapper.deleteCollectBar(collectbar);
        System.out.println(i);
    }
}