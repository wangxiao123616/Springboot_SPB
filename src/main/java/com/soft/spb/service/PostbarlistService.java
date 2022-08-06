package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.pojo.vo.PostbarlistVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarlistService extends IService<Postbarlist> {
    //添加帖子,无Video,有Img或Voice
    Integer addBar(Postbarlist postbarlist, MultipartFile[] image, MultipartFile[] voice) throws IOException;


    Integer addBarVideo(Postbarlist postbarlist, MultipartFile[] video);

    //删除帖子,有Video,无Img和Voice
    Boolean deleteBar(String pbId);

    //获取帖子详细信息
    List<Postbarlist> queryBarDetatilForPbid(Postbarlist postbarlist);

    //根据时间获取帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoBarListForDate(Long id);

    //根据时间获取用户关注帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoFollowBarListForDate(Long id, String userAccount);

    //根据时间获取用户搜索帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoSearchBarListForDate(String searChArt);

    //根据时间获取用户搜索帖子列表(Video)
    List<PostbarlistVo> queryVideoSearchBarListForDate(String searChArt);

    //根据时间获取话题帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoTopicBarListForDate(Long id, String pbTopic);

    //根据点赞获取话题帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic);

    // 根据时间获取用户帖子列表(无Video)
    List<PostbarlistVo> queryNoVideoUserBarListForDate(Long id, String userAccount);

    //获取用户帖子数量
    int queryUserBarCount(String userAccount);

    //2.4.12. 获取用户帖子被赞总数
    Integer postbarlist(String userAccount);

    //2.4.13. 根据时间获取帖子列表(有Video)
    List<PostbarlistVo> queryVideoBarListForDate(Long id);

    //2.4.14 根据时间获取话题帖子列表(有Video)
    List<PostbarlistVo> queryVideoTopicBarListForDate(Long id, String pbTopic);

    //2.4.15. 根据时间获取用户帖子列表(有Video)
    List<PostbarlistVo> queryVideoUserBarListForDate(Long id, String userAccount);


    Map<String, Object> querySearch(String search);
}
