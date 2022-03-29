package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.UserSign;
import com.soft.spb.mapper.UserSignMapper;
import com.soft.spb.service.UserSignService;
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
public class UserSignServiceImpl extends ServiceImpl<UserSignMapper, UserSign> implements UserSignService {

    private final UserSignMapper userSignMapper;

    @Override
    public List<UserSign> queryUserBadge(String userAccount) {

        List<UserSign> userSigns = userSignMapper.queryUserBadge(userAccount);
        return userSigns;
    }

    @Override
    public List<UserSign> queryUserSign(String userAccount) {
        List<UserSign> userSigns = userSignMapper.queryUserSign(userAccount);
        return userSigns;
    }

    @Override
    public Integer updateSignCoin(UserSign userSign) {
        int count = userSignMapper.updateSignCoin(userSign.getSignCoin(), userSign.getUserAccount());
        return count;

    }

    @Override
    public Integer updateSignDay(UserSign userSign) {

        int count = userSignMapper.updateSignDay(userSign.getUserAccount());
        return count;
    }

    @Override
    public Integer updateSignDayAndRight(UserSign userSign) {
        int count = userSignMapper.updateSignDayAndRight(userSign.getUserAccount());
        return count;
    }

    @Override
    public Integer updateSignDayAndRightAndCoin(UserSign userSign) {
        int count = userSignMapper.updateSignDayAndRightAndCoin(userSign.getSignDay(),  userSign.getSignCoin(), userSign.getUserAccount());

        return count;
    }

    @Override
    public Integer updateSignLikeBadge(UserSign userSign) {
        int count = userSignMapper.updateSignLikeBadge(userSign.getSignLikeBadge(), userSign.getUserAccount());
        return count;
    }

    @Override
    public Integer updateSignRight(UserSign userSign) {
        int count = userSignMapper.updateSignRight(userSign.getUserAccount());
        return count;
    }

    @Override
    public int updateSignStarBadge(UserSign userSign) {
        int count = userSignMapper.updateSignLikeBadge(userSign.getSignStarBadge(), userSign.getUserAccount());
        return count;
    }

    @Override
    public int updateSignTaskBadge(UserSign userSign) {
        int count = userSignMapper.updateSignTaskBadge(userSign.getSignTaskBadge(), userSign.getUserAccount());
        return count ;
    }

}
