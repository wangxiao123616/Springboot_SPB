package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.UserSign;
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
public interface UserSignMapper extends BaseMapper<UserSign> {

    /**
     * 2.11.1. 获取用户徽章
     *
     * @param userSign
     * @return
     */
    List<UserSign> queryUserBadge(String userAccount);

    /**
     * 2.11.2. 获取用户签到信息
     *
     * @param userAccount
     * @return
     */
    UserSign queryUserSign(String userAccount);

    /**
     * 2.11.3. 更新金币
     *
     * @param userAccount
     * @return
     */
    int updateSignCoin(@Param("signCoin") Integer signCoin, @Param("userAccount") String userAccount);

    /**
     * 2.11.4. 更新签到天数
     *
     * @param signDay
     * @param userAccount
     * @return
     */
    int updateSignDay(String userAccount);

    /**
     * 2.11.5. 更新断签到
     *
     * @return
     */
    int updateSignDayAndRight(String userAccount);

    /**
     * 2.11.6. 更新已签到
     *
     * @param signDay
     * @param signCoin
     * @param userAccount
     * @return
     */
    int updateSignDayAndRightAndCoin(@Param("signDay") String signDay, @Param("signCoin") Integer signCoin, @Param("userAccount") String userAccount);

    /**
     * 2.11.7. 更新点赞徽章
     * @param signLikeBadge
     * @param userAccount
     * @return
     */
    int updateSignLikeBadge(@Param("signLikeBadge") String signLikeBadge, @Param("userAccount") String userAccount);

    /**
     * 2.11.8. 更新未签到
     * @param userAccount
     * @return
     */
    int updateSignRight(String userAccount);

    /**
     * 2.11.9. 更新星座徽章
     * @param signStarBadge
     * @param userAccount
     * @return
     */
    int updateSignStarBadge(@Param("signStarBadge")String signStarBadge,@Param("userAccount")String userAccount);

    /**
     * 2.11.10. 更新任务徽章
     * @param signTaskBadge
     * @param userAccount
     * @return
     */
    int updateSignTaskBadge(@Param("signTaskBadge")String signTaskBadge,@Param("userAccount")String userAccount);

}
