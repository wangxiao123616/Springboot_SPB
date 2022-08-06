package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.pojo.entity.UserSign;
import com.soft.spb.mapper.UserSignMapper;
import com.soft.spb.service.UserSignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    private final UserMapper userMapper;

    @Override
    public UserSign queryUserBadge(String userAccount) {

        List<UserSign> userSigns = userSignMapper.queryUserBadge(userAccount);
        return userSigns.get(0);
    }

    @Override
    public UserSign queryUserSign(String userAccount) {
        UserSign userSigns = userSignMapper.queryUserSign(userAccount);
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateSignDayAndRightAndCoin(UserSign userSign) {
        int count = userSignMapper.updateSignDayAndRightAndCoin(userSign.getSignDay(),  userSign.getSignCoin(), userSign.getUserAccount());
        int count1 = userMapper.updateUserLongDay(userSign.getUserAccount());
        if (count == 1 && count1 == 1){
            return true;
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public Boolean updateSignLikeBadge(UserSign userSign) {
        int count = userSignMapper.updateSignLikeBadge(userSign.getSignLikeBadge(), userSign.getUserAccount());
        return SqlProcess.transactionalProcess(count);
    }

    @Override
    public Integer updateSignRight(UserSign userSign) {
        int count = userSignMapper.updateSignRight(userSign.getUserAccount());
        return count;
    }

    @Override
    public int updateSignStarBadge(UserSign userSign) {
        int count = userSignMapper.updateSignStarBadge(userSign.getSignStarBadge(), userSign.getUserAccount());
        return count;
    }

    @Override
    public Boolean updateSignTaskBadge(UserSign userSign) {
        int count = userSignMapper.updateSignTaskBadge(userSign.getSignTaskBadge(), userSign.getUserAccount());
        return SqlProcess.transactionalProcess(count);
    }

    @Override
    public boolean initSignDay() {
        int update1 = userSignMapper.update(null, Wrappers.<UserSign>lambdaUpdate().eq(UserSign::getSignRight, 1)
                .set(UserSign::getSignDay, ""));
        int update = userSignMapper.update(null, Wrappers.<UserSign>lambdaUpdate().eq(UserSign::getSignRight, 0)
                .set(UserSign::getSignRight, 1));
        return true;
    }
}
