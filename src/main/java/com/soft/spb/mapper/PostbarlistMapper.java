package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Postbarlist;

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
     *2.4.1. 添加帖子(无Video,有Img或Voice)
     * @param postbarlist
     * @return
     */

    int addBar(Postbarlist postbarlist);

    /**
     * 2.4.2. 添加帖子(有Video,无Img和Voice)
     * @param postbarlist
     * @return
     */
    int addBarVideo(Postbarlist postbarlist);

    /**
     * 删除数据
     * @param pbOneId
     * @return
     */
    int deleteBar(String pbOneId);

    /**
     * 获取帖子信息
     * @param pbOneId
     * @return
     */
    List<Postbarlist> queryBarDetatilForPbid(String pbOneId);


    /**
     * 根据时间获取帖子列表(无Video)
     * @param date
     * @return
     */
    List<Postbarlist> queryNoVideoBarListForDate(String date);

    /**
     * 2.4.6. 根据时间获取用户关注帖子列表(无Video)
     * @param pbDate
     * @param userAccount
     * @return
     */
    List<Postbarlist> queryNoVideoFollowBarListForDate( String pbDate,String userAccount);


    /**
     * 根据时间获取用户搜索帖子列表(无Video)
     * @param searChArt
     * @param pbArticle
     * @return
     */
    List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt,String pbArticle);


    /**
     * 根据时间获取话题帖子列表(无Video)
     * @param pbDate
     * @param pbTopic
     * @return
     */
    List<Postbarlist> queryNoVideoTopicBarListForDate(String pbDate,String pbTopic);


    /**
     * 根据点赞获取话题帖子列表(无Video)
     * @param pbThumbNum
     * @param pbTopic
     * @return
     */
    List<Postbarlist> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum, String pbTopic);


    /**
     * 根据时间获取用户帖子列表(无Video)
     * @param pbDate
     * @param userAccount
     * @return
     */
    List<Postbarlist> queryNoVideoUserBarListForDate(String pbDate, String userAccount);


    /**
     * 获取用户帖子数量
     * @param userAccount
     * @return
     */
    List<Postbarlist> queryUserBarCount(String userAccount);


    /**
     * 2.4.12. 获取用户帖子被赞总数
     * @param userAccount
     * @return
     */
    Integer postbarlist(String userAccount);


    /**
     * 2.4.13. 根据时间获取帖子列表(有Video)
     * @param searChArt
     * @param pbArticle
     * @return
     */
    List<Postbarlist> queryVideoBarListForDate(String searChArt, String pbArticle);

    /**
     * 2.4.14 根据时间获取话题帖子列表(有Video)
     * @param pbDate
     * @param pbTopic
     * @return
     */
    List<Postbarlist> queryVideoTopicBarListForDate(String pbDate,String pbTopic);


    /**
     * 2.4.15. 根据时间获取用户帖子列表(有Video)
     * @param pbDate
     * @param userAccount
     * @return
     */
    List<Postbarlist>queryVideoUserBarListForDate(String pbDate, String userAccount);

}
