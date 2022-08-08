package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.vo.UserVo;
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


    List<UserVo> querySearchUser(String search);

    int updateUserBadgeImage(String userBadge,String userAccount);

    Integer updateUserBgImage(MultipartFile[] userBgImage, String userAccount);

    Integer updateUserHeadImage(MultipartFile[] userHeadImage,String userAccount);

    Map<String, Object> getUserInfoToken(String userAccount,String token);

    Map<String, Object> getUserInfo(String userAccount);

    Map<String, Object> getUserInfo();

    int updateUserIp(User user);

    Boolean updateUserPersonalInformation(User user);

    int updateUserPrivacy(User user);

    int updateUserToken(User user);

}
