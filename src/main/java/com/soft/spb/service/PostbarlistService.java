package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Postbarlist;

import java.util.List;

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
 int addBar(Postbarlist postbarlist);

 String addBarVideo(Postbarlist postbarlist);

 //删除帖子,有Video,无Img和Voice
 Boolean deleteBar(String pbId);

 //获取帖子详细信息
 List<Postbarlist> queryBarDetatilForPbid(Postbarlist postbarlist);

 //根据时间获取帖子列表(无Video)
 List<Postbarlist> queryNoVideoBarListForDate(String date);

 //根据时间获取用户关注帖子列表(无Video)
 List<Postbarlist> queryNoVideoFollowBarListForDate(String pbDate,String userAccount);

 //根据时间获取用户搜索帖子列表(无Video)
 List<Postbarlist> queryNoVideoSearchBarListForDate(String searChArt, String pbArticle);

 //根据时间获取话题帖子列表(无Video)
 List<Postbarlist> queryNoVideoTopicBarListForDate(String pbDate, String pbTopic);

 //根据点赞获取话题帖子列表(无Video)
 List<Postbarlist> queryNoVideoTopicBarListForThumbNum(Integer pbThumbNum,String pbTopic);
 // 根据时间获取用户帖子列表(无Video)
 List<Postbarlist> queryNoVideoUserBarListForDate(String pbDate,String userAccount);
  //获取用户帖子数量
 List<Integer> queryUserBarCount(String userAccount);
}
