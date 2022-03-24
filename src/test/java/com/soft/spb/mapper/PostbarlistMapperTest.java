package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Postbarlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PostbarlistMapperTest {
    @Autowired
    PostbarlistMapper postbarlistMapper;

    @Test
    void addBar() {
        Postbarlist postbarlist = new Postbarlist();
        postbarlist.setId(180);
        postbarlist.setPbArticle("好嗨呦");
        postbarlist.setPbCommentNum(22222333);
        LocalDateTime localDateTime = LocalDateTime.now();
        postbarlist.setPbDate(localDateTime);
        postbarlist.setPbImageUrl("123");
        postbarlist.setPbLocation("南京");
        postbarlist.setPbOneId("wan");
        postbarlist.setPbThumbNum(23);
        postbarlist.setPbTopic("新问鼎");
        postbarlist.setPbVideo("好好学");
        postbarlist.setPbVoice("美信");
        postbarlist.setUserAccount("小王");
        int a = postbarlistMapper.addBar(postbarlist);
        System.out.println(a);

    }

    @Test
    void queryAll() {


        System.out.println(postbarlistMapper.queryAll());
    }

    @Test
    void deleteBar() {
        postbarlistMapper.deleteBar("a1");

    }

    @Test
    void queryBarDetatilForPbid() {
        for (Postbarlist data : postbarlistMapper.queryBarDetatilForPbid("20cce1b200b046f20eb517408f3a6477G18190405")) {
            System.out.println(data);
        }


    }

    @Test
    void queryNoVideoFollowBarListForDate() {
       // System.out.println(postbarlistMapper.queryNoVideoFollowBarListForDate("2021-12-3 12:00:00"));


    }

    @Test
    void queryNoVideoSearchBarListForDate() {
        System.out.println(postbarlistMapper.queryNoVideoSearchBarListForDate("王者","哈哈哈"));
    }

    @Test
    void queryNoVideoTopicBarListForDate() {
        //System.out.println( postbarlistMapper.queryNoVideoTopicBarListForDate("2021-8-5 12:00:00","哈哈"));

    }

    @Test
    void testQueryNoVideoFollowBarListForDate() {
      //  System.out.println(postbarlistMapper.queryNoVideoFollowBarListForDate("2022-3-3 12:00:00"));
    }


    @Test
    void queryUserBarCount() {

      for (Postbarlist data: postbarlistMapper.queryUserBarCount("G18190405")
             ) {
            System.out.println(data);

        }


    }
}