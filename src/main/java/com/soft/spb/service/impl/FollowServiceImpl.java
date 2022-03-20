package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.mapper.FollowMapper;
import com.soft.spb.service.FollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {

    private final FollowMapper followMapper;

    @Override
    public boolean isFollowed(Follow follow) {
        List<Follow> followList = followMapper.getFollow();

        boolean isFollowed = false;
        for (int i = 0; i < followList.size(); i++) {
            Follow f = followList.get(i);
            if (f.getFollowAccount().equals(follow.getFollowAccount()) && f.getFollowedAccount().equals(follow.getFollowedAccount())) {
                isFollowed = true;
                break;
            }
        }
        if (!isFollowed) {
            followMapper.addFollow(follow);
        }
        return isFollowed;
    }

    @Override
    public boolean deleteFollow(Follow follow) {
        List<Follow> followList = followMapper.getFollow();

        boolean isFollowed = false;
        for (int i = 0; i < followList.size(); i++) {
            Follow f = followList.get(i);
            if (f.getFollowAccount().equals(follow.getFollowAccount()) && f.getFollowedAccount().equals(follow.getFollowedAccount())) {
                isFollowed = true;
                followMapper.deleteFollow(follow.getFollowAccount(), follow.getFollowedAccount());
                break;
            }

        }
        return isFollowed;
    }

    @Override
    public Integer queryFollowAccount(Follow follow) {

        List<Follow> follows = followMapper.queryFollowAccount(follow.getFollowAccount());
        int account = follows.size();
        return account;

    }
     @Override
    public List<Follow> queryFollowList(Follow follow){
         List<Follow> followList = followMapper.queryFollowList(follow.getFollowAccount());
         return followList;
     }

    @Override
    public Integer queryFollowedCount(Follow follow) {
        List<Follow> follows = followMapper.queryFollowedCount(follow.getFollowedAccount());
        int size = follows.size();
        return size;
    }
}
