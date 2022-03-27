package com.soft.spb.service;

import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface UserService extends IService<User> {

    int deleteUserIp(String userAccount);

    List<Course> querySchoolTable();

    List<User> querySearchUser(String search);

    int updateUserBadgeImage(String userBadge,String userAccount);
}
