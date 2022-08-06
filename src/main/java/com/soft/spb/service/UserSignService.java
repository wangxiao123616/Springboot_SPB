package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.UserSign;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface UserSignService extends IService<UserSign> {

    UserSign queryUserBadge(String userAccount);

    UserSign queryUserSign(String userAccount);

    Integer updateSignCoin(UserSign userSign);

    Integer updateSignDay(UserSign userSign);

    Integer updateSignDayAndRight(UserSign userSign);

    Boolean updateSignDayAndRightAndCoin(UserSign userSign);

    Boolean updateSignLikeBadge(UserSign userSign);

    Integer updateSignRight(UserSign userSign);

    int updateSignStarBadge(UserSign userSign);

    Boolean updateSignTaskBadge(UserSign userSign);

    boolean initSignDay();

}
