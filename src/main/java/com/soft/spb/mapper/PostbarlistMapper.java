package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.pojo.vo.PostbarlistVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarlistMapper extends BaseMapper<Postbarlist> {

    List<Postbarlist> queryAll();

    /**
     * 2.4.1. 添加帖子(无Video,有Img或Voice)
     *
     * @param postbarlist
     * @return
     */

    int addBar(Postbarlist postbarlist);

    /**
     * 2.4.2. 添加帖子(有Video,无Img和Voice)
     *
     * @param postbarlist
     * @return
     */
    int addBarVideo(Postbarlist postbarlist);

    /**
     * 删除数据
     *
     * @param pbOneId
     * @return
     */
    int deleteBar(String pbOneId);

    /**
     * 获取帖子信息
     *
     * @param pbOneId
     * @return
     */
    List<Postbarlist> queryBarDetatilForPbid(String pbOneId);


    /**
     * 根据时间获取帖子列表(无Video)
     *
     * @param id
     * @return
     */
    List<PostbarlistVo> queryNoVideoBarListForDate(Long id);

    /**
     * 2.4.6. 根据时间获取用户关注帖子列表(无Video)
     *
     * @param id
     * @param userAccount
     * @return
     */
    List<PostbarlistVo> queryNoVideoFollowBarListForDate(Long id, String userAccount);


    /**
     * 根据时间获取用户搜索帖子列表(无Video)
     *
     * @param searChArt
     * @return
     */
    List<PostbarlistVo> queryNoVideoSearchBarListForDate(String searChArt);
    /**
     * 根据时间获取用户搜索帖子列表(Video)
     *
     * @param searChArt
     * @return
     */
    List<PostbarlistVo> queryVideoSearchBarListForDate(String searChArt);


    /**
     * 根据时间获取话题帖子列表(无Video)
     *
     * @param id
     * @param pbTopic
     * @return
     */
    List<PostbarlistVo> queryNoVideoTopicBarListForDate(Long id, String pbTopic);


    /**
     * 根据点赞获取话题帖子列表(无Video)
     *
     * @param pbThumbNum
     * @param pbTopic
     * @return
     */
    List<PostbarlistVo> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic);


    /**
     * 根据时间获取用户帖子列表(无Video)
     *
     * @param id
     * @param userAccount
     * @return
     */
    List<PostbarlistVo> queryNoVideoUserBarListForDate(Long id, String userAccount);


    /**
     * 获取用户帖子数量
     *
     * @param userAccount
     * @return
     */
    List<Postbarlist> queryUserBarCount(String userAccount);


    /**
     * 2.4.12. 获取用户帖子被赞总数
     *
     * @param userAccount
     * @return
     */
    Integer postbarlist(String userAccount);


    /**
     * 2.4.13. 根据时间获取帖子列表(有Video)
     *
     * @return
     */
    List<PostbarlistVo> queryVideoBarListForDate(Long id);

    /**
     * 2.4.14 根据时间获取话题帖子列表(有Video)
     *
     * @param id
     * @param pbTopic
     * @return
     */
    List<PostbarlistVo> queryVideoTopicBarListForDate(Long id, String pbTopic);


    /**
     * 2.4.15. 根据时间获取用户帖子列表(有Video)
     *
     * @param id
     * @param userAccount
     * @return
     */
    List<PostbarlistVo> queryVideoUserBarListForDate(Long id, String userAccount);

    /**
     * @Description: 帖子点赞＋1
     * @Param: [pbid]
     * @return: int
     * @Author: nmy
     * @Date: 2022-04-19 17:39
     */
    int updateIncreaseLike(@Param("pb_one_id") String pbid);

    /**
     * @Description: 帖子点赞－1
     * @Param: [pbid]
     * @return: int
     * @Author: nmy
     * @Date: 2022-04-19 17:40
     */
    int updateReduceLike(@Param("pb_one_id") String pbid);

    int updateIncreaseComment(@Param("pb_one_id") String pbid);

    int updateReduceComment(@Param("pb_one_id") String pbid);
}
