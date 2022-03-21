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
        postbarlist.setPbCommentNum(22333);

        LocalDateTime localDateTime = LocalDateTime.now();
        postbarlist.setPbDate(localDateTime);
        postbarlist.setPbLocation("南京");
        postbarlist.setPbOneId("wang");
        postbarlist.setPbThumbNum(23);
        postbarlist.setPbTopic("新问鼎");
        postbarlist.setPbVideo("雪中");
        postbarlist.setPbVoice("美信");
        postbarlist.setUserAccount("小王");
        postbarlistMapper.addBar(postbarlist);
        System.out.println();

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
        for(Postbarlist data :postbarlistMapper.queryBarDetatilForPbid("20cce1b200b046f20eb517408f3a6477G18190405")){
            System.out.println(data);
        }
        
      
    }
}