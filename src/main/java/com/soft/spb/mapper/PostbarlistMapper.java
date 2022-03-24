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
       //添加帖子
    int addBar(Postbarlist postbarlist);

    //删除数据
    int deleteBar(String pbOneId);

    //获取帖子信息

    List<Postbarlist> queryBarDetatilForPbid(String pbOneId);

    //根据时间获取帖子列表(无Video)
    List<Postbarlist> queryNoVideoBarListForDate(String date);

    List<Postbarlist> queryNoVideoFollowBarListForDate( String pbDate,String userAccount);

    // 根据时间获取用户搜索帖子列表(无Video)
    List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt,String pbArticle);

    // 根据时间获取话题帖子列表(无Video)
    List<Postbarlist> queryNoVideoTopicBarListForDate(String pbDate,String pbTopic);

    //根据点赞获取话题帖子列表(无Video)
    List<Postbarlist> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum,String pbTopic);

    //根据时间获取用户帖子列表(无Video)
    List<Postbarlist> queryNoVideoUserBarListForDate(String pbDate,String userAccount);

    //获取用户帖子数量
    List<Postbarlist> queryUserBarCount(String userAccount);



}
