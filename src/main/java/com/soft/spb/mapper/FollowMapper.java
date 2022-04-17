package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.dto.FollowDto;
import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.pojo.vo.FollowListVo;
import com.soft.spb.pojo.vo.RandomUserVo;
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

    /**
     * 查询所需数据
     * @return
     */
    List<Follow> getFollow();


    /**
     * 添加关注
     * @param follow
     * @return
     */
    int addFollow(Follow follow);

    /**
     * 删除关注,多个字段用@Param
     * @param followAccount
     * @param followedAccount
     * @return
     */
    int deleteFollow(@Param("followAccount") String followAccount, @Param("followedAccount") String followedAccount);


    /**
     * 获取关注数
     * @param followAccount
     * @return
     */
    List<Follow> queryFollowAccount(String followAccount);


    /**
     * 获取关注用户列表
     * @param followList
     * @return
     */
    List<String> queryFollowList(String followList);


    /**
     * 获取关注用户信息列表
     * @param followDto
     * @return
     */
    List<FollowListVo> queryFollowUserList(FollowDto followDto);


    /**
     * 获取被关注数
     * @param followedAccount
     * @return
     */
    List<Follow> queryFollowedCount(String followedAccount);

    /**
     * 获取被关注用户列表
     * @param followedAccount
     * @return
     */
    List<String> queryFollowedList(String followedAccount);


    /**
     * 获取用户被关注信息列表
     * @param followDto
     * @return
     */
    List<FollowListVo> queryFollowedUserList(FollowDto followDto);

    List<RandomUserVo> queryRundomUserList(int num);
}
