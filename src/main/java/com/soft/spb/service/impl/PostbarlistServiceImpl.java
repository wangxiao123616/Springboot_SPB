package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.mapper.TopicMapper;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.pojo.vo.UserVo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Integer addBarVideo(Postbarlist bar, MultipartFile[] video) {
        LocalDateTime now = LocalDateTime.now();
        bar.setPbDate(now);
        bar.setPbOneId(MD5Util.md5(DateTool.obtainNowDateTime() + bar.getUserAccount()));
        if (video != null && video.length > 0) {
            List<String> postVideo = AliOssUtil.upload(video);
            if (postVideo == null) {
                return null;
            }
            bar.setPbVideo(String.valueOf(postVideo.get(0)));
        }
        return postbarlistMapper.addBar(bar);
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
    public List<PostbarlistVo> queryNoVideoSearchBarListForDate(String searChArt) {
        return postbarlistMapper.queryNoVideoSearchBarListForDate(searChArt);
    }

    @Override
    public List<PostbarlistVo> queryVideoSearchBarListForDate(String searChArt) {
        return postbarlistMapper.queryVideoSearchBarListForDate(searChArt);

    }

    @Override
    public List<PostbarlistVo> queryNoVideoTopicBarListForDate(Long id, String pbTopic) {
        List<PostbarlistVo> topiclists = postbarlistMapper.queryNoVideoTopicBarListForDate(id, pbTopic);
        return topiclists;

    }

    @Override
    public List<PostbarlistVo> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic) {
        if (pbThumbNum == -1){
            pbThumbNum = 1000000;
        }
        List<PostbarlistVo> barListForThumbNum = postbarlistMapper.queryNoVideoTopicBarListForThumbNum(pbThumbNum, pbTopic);
        return barListForThumbNum;
    }

    @Override
    public List<PostbarlistVo> queryNoVideoUserBarListForDate(Long id, String userAccount) {
        return postbarlistMapper.queryNoVideoUserBarListForDate(id, userAccount);
    }

    @Override
    public int queryUserBarCount(String userAccount) {
        List<Postbarlist> userBarCountList = postbarlistMapper.queryUserBarCount(userAccount);
        return userBarCountList.size();
    }

    @Override
    public Integer postbarlist(String userAccount) {
        Integer thumbNum = postbarlistMapper.postbarlist(userAccount);
        return thumbNum;
    }

    @Override
    public List<PostbarlistVo> queryVideoBarListForDate(Long id) {
        List<PostbarlistVo> barlists = postbarlistMapper.queryVideoBarListForDate(id);
        return barlists;

    }

    @Override
    public List<PostbarlistVo> queryVideoTopicBarListForDate(Long id, String pbTopic) {
        List<PostbarlistVo> postbarlistst = postbarlistMapper.queryVideoTopicBarListForDate(id, pbTopic);
        return postbarlistst;
    }

    @Override
    public List<PostbarlistVo> queryVideoUserBarListForDate(Long id, String userAccount) {
        List<PostbarlistVo> postbarlists = postbarlistMapper.queryVideoUserBarListForDate(id, userAccount);
        return postbarlists;
    }

    private final UserMapper userMapper;
    private final TopicMapper topicMapper;

    @Override
    public Map<String, Object> querySearch(String search) {
        List<UserVo> userVos = userMapper.querySearchUser(search);
        List<Topic> topics = topicMapper.querySearchTopicList(search);
        List<PostbarlistVo> postbarlistNoV = postbarlistMapper.queryNoVideoSearchBarListForDate(search);
        List<PostbarlistVo> postbarlistV = postbarlistMapper.queryVideoSearchBarListForDate(search);
        Map<String, Object> map = new HashMap<>();
        map.put("userVos",userVos);
        map.put("topics",topics);
        map.put("postbarlistNoV",postbarlistNoV);
        map.put("postbarlistV",postbarlistV);
        return map;
    }
}
