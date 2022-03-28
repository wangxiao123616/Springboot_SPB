package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;

import java.util.List;
import java.util.Map;

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
    Map<String, Object> getUserInfo(String userAccount);

}
