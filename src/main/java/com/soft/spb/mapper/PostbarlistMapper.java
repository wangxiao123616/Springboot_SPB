package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Postbarlist;
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
       //添加帖子
    int addBar(Postbarlist postbarlist);

    //删除数据
    int deleteBar(String pbOneId);

    //获取帖子信息

    List<Postbarlist> queryBarDetatilForPbid(String pbOneId);

    //根据时间获取帖子列表(无Video)
    List<Postbarlist> queryNoVideoBarListForDate(String date);

    List<Postbarlist> queryNoVideoFollowBarListForDate(String date);

    // 根据时间获取用户搜索帖子列表(无Video)
    List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt);

    // 根据时间获取话题帖子列表(无Video)
    List<Postbarlist> queryNoVideoTopicBarListForDate(@Param("pbDate")String pbDate,@Param("topicName") String topicName);

    
}
