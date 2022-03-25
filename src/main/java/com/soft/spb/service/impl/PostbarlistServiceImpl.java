package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.service.PostbarlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PostbarlistServiceImpl extends ServiceImpl<PostbarlistMapper, Postbarlist> implements PostbarlistService {
    private final PostbarlistMapper postbarlistMapper;


    @Override
    public int addBar(Postbarlist postbarlist) {

        postbarlist.setPbCommentNum(0);
        postbarlist.setPbDate(LocalDateTime.now());
        if (postbarlist.getPbVoice() != null && postbarlist.getPbImageUrl() != null && postbarlist.getPbVideo() == null) {
            return postbarlistMapper.addBar(postbarlist);
        } else {
            return 0;
        }


    }

    @Override
    public String addBarVideo(Postbarlist postbarlist) {
        // 对这三个进行判断:有Video,无Img和Voice
        return null;
    }

    @Override
    public Boolean deleteBar(String pbId) {

        List<Postbarlist> postbarlists = postbarlistMapper.queryAll();
        boolean isBar = false;

        for (int i = 0; i < postbarlists.size(); i++) {

            Postbarlist p = postbarlists.get(i);

            if (p.getPbOneId().equals(pbId)) {
                isBar = true;
                postbarlistMapper.deleteBar(p.getPbOneId());
                break;
            }

        }
        return isBar;
    }

    @Override
    public List<Postbarlist> queryBarDetatilForPbid(Postbarlist postbarlist) {
        List<Postbarlist> detatil = postbarlistMapper.queryBarDetatilForPbid(postbarlist.getPbOneId());
        return detatil;
    }

    @Override
    public List<Postbarlist> queryNoVideoBarListForDate(String date) {
        String dateStirng = null;

        if (date.length() < 2) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateStirng = now.format(dateFormat);
        } else {
            dateStirng = date;
        }
        System.out.println(dateStirng);
        List<Postbarlist> items = postbarlistMapper.queryNoVideoBarListForDate(dateStirng);
        return items;
    }

    @Override
    public List<Postbarlist> queryNoVideoFollowBarListForDate(String pbDate, String userAccount) {
        String dS = null;
        System.out.println(pbDate);
        if (pbDate.length() < 2) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dS = now.format(dateFormat);
        } else {
            dS = pbDate;
        }
        System.out.println(dS);
        List<Postbarlist> items = postbarlistMapper.queryNoVideoFollowBarListForDate(dS, userAccount);
        return items;
    }


    @Override
    public List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt, String pbArticle) {

        List<Postbarlist> barlists = postbarlistMapper.queryNoVideoSearchBarListForDate(searChArt, pbArticle);
        return barlists;

    }

    @Override
    public List<Postbarlist> queryNoVideoTopicBarListForDate(String pbDate, String pbTopic) {

        List<Postbarlist> topiclists = postbarlistMapper.queryNoVideoTopicBarListForDate(pbDate, pbTopic);
        return topiclists;

    }

    @Override
    public List<Postbarlist> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic) {
        List<Postbarlist> barListForThumbNum = postbarlistMapper.queryNoVideoTopicBarListForThumbNum(pbThumbNum, pbTopic);
        return barListForThumbNum;
    }

    @Override
    public List<Postbarlist> queryNoVideoUserBarListForDate(String pbDate, String userAccount) {
        List<Postbarlist> userBarListForDate = postbarlistMapper.queryNoVideoUserBarListForDate(pbDate, userAccount);

        return userBarListForDate;
    }

    @Override
    public List<Integer> queryUserBarCount(String userAccount) {

        List<Postbarlist> userBarCountList = postbarlistMapper.queryUserBarCount(userAccount);
        List<Integer> postbarlists = new ArrayList<>();

        for (int i = 0; i <userBarCountList.size() ; i++) {
            postbarlists.add(userBarCountList.get(i).getId());

        }

        return postbarlists;
    }

   @Override
    public Integer postbarlist(String userAccount) {
       Integer thumbNum = postbarlistMapper.postbarlist(userAccount);
       return thumbNum;
   }

    @Override
    public List<Postbarlist> queryVideoBarListForDate(String searChArt, String pbArticle) {

        List<Postbarlist> barlists = postbarlistMapper.queryVideoBarListForDate(searChArt, pbArticle);
        return barlists;

    }

    @Override
    public List<Postbarlist> queryVideoTopicBarListForDate(String pbDate, String pbTopic) {
        List<Postbarlist> postbarlistst = postbarlistMapper.queryVideoTopicBarListForDate(pbDate, pbTopic);
        return postbarlistst;
    }

    @Override
    public List<Postbarlist> queryVideoUserBarListForDate(String pbDate, String userAccount) {
        List<Postbarlist> postbarlists = postbarlistMapper.queryVideoUserBarListForDate(pbDate, userAccount);
        return postbarlists;
    }


}
