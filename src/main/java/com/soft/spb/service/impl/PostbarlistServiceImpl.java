package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.service.PostbarlistService;
import com.soft.spb.util.AliOssUtil;
import com.soft.spb.util.DateTool;
import com.soft.spb.util.MD5Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@RequiredArgsConstructor
public class PostbarlistServiceImpl extends ServiceImpl<PostbarlistMapper, Postbarlist> implements PostbarlistService {
    private final PostbarlistMapper postbarlistMapper;


    @Override
    public Integer addBar(Postbarlist bar, MultipartFile[] image, MultipartFile[] voice) throws IOException {

        LocalDateTime now = LocalDateTime.now();
        bar.setPbDate(now);
        bar.setPbOneId(MD5Util.md5(DateTool.obtainNowDateTime() + bar.getUserAccount()));
        if (image != null && image.length > 0) {
            List<String> postBarImageUrl = AliOssUtil.upload(image);
            if (postBarImageUrl == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < postBarImageUrl.size(); i++) {
                stringBuilder.append(postBarImageUrl.get(i)).append("|");
            }
            bar.setPbImageUrl(String.valueOf(stringBuilder));
        }
        if (voice != null) {
            List<String> postBarVoiceUrl = AliOssUtil.upload(voice);
            if (postBarVoiceUrl == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < postBarVoiceUrl.size(); i++) {
                stringBuilder.append(postBarVoiceUrl.get(i));
            }
            bar.setPbVoice(String.valueOf(postBarVoiceUrl));
        }
        return postbarlistMapper.addBar(bar);
    }


    @Override
    public Integer addBarVideo(Postbarlist postbarlist, MultipartFile[] video) {

        LocalDateTime now = LocalDateTime.now();
        postbarlist.setPbDate(now);
        // 对这三个进行判断:有Video,无Img和Voice
        if (video != null) {
            List<String> postVideo = AliOssUtil.upload(video);
            if (postVideo == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < postVideo.size(); i++) {
                stringBuilder.append(postVideo.get(i));
            }
            postbarlist.setPbVideo(String.valueOf(postVideo));
        }
        return postbarlistMapper.addBarVideo(postbarlist);
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
    public List<PostbarlistVo> queryNoVideoBarListForDate(Long id) {
        List<PostbarlistVo> items = postbarlistMapper.queryNoVideoBarListForDate(id);
        return items;
    }

    @Override
    public List<PostbarlistVo> queryNoVideoFollowBarListForDate(Long id, String userAccount) {
        List<PostbarlistVo> items = postbarlistMapper.queryNoVideoFollowBarListForDate(id, userAccount);
        return items;
    }


    @Override
    public List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt, String pbArticle) {

        List<Postbarlist> barlists = postbarlistMapper.queryNoVideoSearchBarListForDate(searChArt, pbArticle);
        return barlists;

    }

    @Override
    public List<PostbarlistVo> queryNoVideoTopicBarListForDate(String pbDate, String pbTopic) {
        String dateStirng = DateTool.queryInitDate(pbDate);
        List<PostbarlistVo> topiclists = postbarlistMapper.queryNoVideoTopicBarListForDate(dateStirng, pbTopic);
        return topiclists;

    }

    @Override
    public List<Postbarlist> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic) {
        List<Postbarlist> barListForThumbNum = postbarlistMapper.queryNoVideoTopicBarListForThumbNum(pbThumbNum, pbTopic);
        return barListForThumbNum;
    }

    @Override
    public List<PostbarlistVo> queryNoVideoUserBarListForDate(Long id, String userAccount) {
        return postbarlistMapper.queryNoVideoUserBarListForDate(id, userAccount);
    }

    @Override
    public List<Integer> queryUserBarCount(String userAccount) {

        List<Postbarlist> userBarCountList = postbarlistMapper.queryUserBarCount(userAccount);
        List<Integer> postbarlists = new ArrayList<>();

        for (int i = 0; i < userBarCountList.size(); i++) {
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
