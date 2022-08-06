package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 2.9.1. 删除用户ip
     * @param userAccount
     * @return
     */
    int deleteUserIp(String userAccount);

    /**
     * 2.9.2. 获取课程表
     * @param course
     * @return
     */
    List<Course> querySchoolTable();

    /**
     * 2.9.3. 搜索用户
     * @param search
     * @return
     */
    List<UserVo> querySearchUser(String search);

    /**
     * 2.9.4. 更新用户使用徽章
     * @param userAccount
     * @return
     */
    int updateUserBadgeImage(String userBadge,String userAccount);

    /**
     * 2.9.5. 更新用户主页背景
     * @param userHeadImage
     * @param userAccount
     * @return
     */
    int updateUserBgImage(String userBgImage,String userAccount);

    /**
     * 2.9.6. 更新用户头像
     * @param userHeadImage
     * @param userAccount
     * @return
     */
    int updateUserHeadImage(String userHeadImage,String userAccount);

    /**
     * 2.9.7. 更新用户ip
     * @param userAccount
     * @return
     */
    int updateUserIp(String userIp,String userAccount);

    /**
     *
     * @param user
     * @return
     */
    int updateUserPersonalInformation(User user);

    /**
     * 2.9.9. 更新用户隐私设置
     * @param user
     * @return
     */

    int updateUserPrivacy(User user);

    /**
     * 2.9.10. 更新用户token
     * @param user
     * @return
     */
   int updateUserToken(User user);

   int updateUserLongDay(String userAccount);
}
