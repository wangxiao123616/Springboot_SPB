package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Follow;
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
public interface FollowMapper extends BaseMapper<Follow> {
       //查询所需数据
    List<Follow> getFollow();

    //添加关注
    int addFollow(Follow follow);

    //删除关注,多个字段用@Param
    int deleteFollow(@Param("followAccount") String followAccount, @Param("followedAccount") String followedAccount);

    //获取关注数
    List<Follow> queryFollowAccount(String followAccount);

    //获取关注用户列表
    List<Follow> queryFollowList(String followList);


    //获取被关注数
    List<Follow> queryFollowedCount(String followedAccount);

    //获取被关注用户列表
    List<Follow> queryFollowedList(String followedAccount);

}
