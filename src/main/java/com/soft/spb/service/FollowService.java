package com.soft.spb.service;

import com.soft.spb.pojo.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

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

    boolean deleteFollow(Follow follow );
}
