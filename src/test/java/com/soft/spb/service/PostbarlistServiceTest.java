package com.soft.spb.service;

import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.service.impl.PostbarlistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostbarlistServiceTest {
    @Autowired
    private PostbarlistServiceImpl postbarlistServiceImpl;

    @Test
    void deleteBar() {

        System.out.println(postbarlistServiceImpl.deleteBar("wang"));

    }

    @Test
    void queryBarDetatilForPbid() {
        Postbarlist postbarlist = new Postbarlist();
        postbarlist.setPbOneId("abea251a3d446ed60e2fe606e9c9bdd7G18190403");
        System.out.println( postbarlistServiceImpl.queryBarDetatilForPbid(postbarlist));

    }
}