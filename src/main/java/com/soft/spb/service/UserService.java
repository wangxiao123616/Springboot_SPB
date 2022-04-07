package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import org.springframework.web.multipart.MultipartFile;

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

    Integer updateUserBgImage(MultipartFile[] userBgImage, String userAccount);

    Integer updateUserHeadImage(MultipartFile[] userHeadImage,String userAccount);


    Map<String, Object> getUserInfo(String userAccount);

    int updateUserIp(User user);

    int updateUserPersonalInformation(User user);

    int updateUserPrivacy(User user);

    int updateUserToken(User user);

}
