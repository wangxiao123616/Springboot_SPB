package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;

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
     * @param user
     * @return
     */
    List<User> querySearchUser(String search);

    /**
     * 2.9.4. 更新用户使用徽章
     * @param userAccount
     * @return
     */
    int updateUserBadgeImage(String userBadge,String userAccount);
}
