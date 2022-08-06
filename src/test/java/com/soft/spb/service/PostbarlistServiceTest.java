package com.soft.spb.service;

import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.service.impl.PostbarlistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostbarlistServiceTest {
    @Autowired
    private PostbarlistServiceImpl postbarlistServiceImpl;

    /*
           @Test
    void addBar() {
        Postbarlist postbarlist = new Postbarlist();
        postbarlist.setId(180);

        postbarlist.setPbArticle("好嗨呦");
        postbarlist.setPbCommentNum(22333);

        LocalDateTime localDateTime = LocalDateTime.now();
        postbarlist.setPbDate(localDateTime);
        postbarlist.setPbLocation("南京");
        postbarlist.setPbOneId("2333333");
        postbarlist.setPbThumbNum(23);
        postbarlist.setPbTopic("热度高");
        postbarlist.setPbVideo("雪中");
        postbarlist.setPbVoice("美信");
        postbarlist.setUserAccount("张三");
      Boolean a =  postbarlistServiceImpl.addBar(postbarlist);
        System.out.println( a);

    }
     */

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

    @Test
    void queryNoVideoBarListForDate() {
       // System.out.println(postbarlistServiceImpl.queryNoVideoBarListForDate("2022-1-21 12:00:00"));
    }

    @Test
    void queryNoVideoFollowBarListForDate() {
        //System.out.println(postbarlistServiceImpl.queryNoVideoBarListForDate("2022-1-3 12:00:00"));

    }

    @Test
    void queryNoVideoSearchBarListForDate() {
//        System.out.println(postbarlistServiceImpl.queryNoVideoSearchBarListForDate("哈哈","王者五"));
    }


    @Test
    void queryNoVideoTopicBarListForDate() {
        //System.out.println(postbarlistServiceImpl.queryNoVideoTopicBarListForDate("2022-3-7 12:00:00","王者")
   //);
    }

    @Test
    void postbarlist() {
        System.out.println(postbarlistServiceImpl.postbarlist("G18190405"));

      }


}