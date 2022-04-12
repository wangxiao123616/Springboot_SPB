package com.soft.spb.service;

import com.soft.spb.pojo.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.vo.RandomUserVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface FollowService extends IService<Follow> {
    boolean isFollowed(Follow follow);

    boolean deleteFollow(Follow follow);

    Integer queryFollowAccount(Follow follow);

    List<String> queryFollowList(Follow follow);

    List<String> queryFollowedList(Follow follow);

    List<Follow> queryFollowUserList(String userAccount);

    Integer queryFollowedCount(Follow follow);

    List<Follow> queryFollowedUserList(String followedUserAccount);

    List<RandomUserVo> queryRundomUserList(int num);
}
