package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.service.UserService;
import com.soft.spb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getUserInfo/{account}")
    public Map<String, Object> getUserInfo(@PathVariable String account) {
        return userService.getUserInfo(account);
    }

    @PostMapping("/deleteUserIp")
    public Integer addCollectBar(@RequestBody User user) {
        int count = userService.deleteUserIp(user.getUserAccount());
        return count;
    }

      @PostMapping("/querySchoolTable")
    public List<Course> querySchoolTable(){
        return userService.querySchoolTable();
      }

      @PostMapping("/querySearchUser/{search}")
    public List<User> querySearchUser(@PathVariable String search){
          List<User> users = userService.querySearchUser(search);
         return users;
      }
      @PostMapping("/updateUserBadgeImage")
    public int updateUserBadgeImage(@RequestBody User user){
          int count = userService.updateUserBadgeImage(user.getUserBadge(),user.getUserAccount());
          return count;

      }

      @PostMapping("/updateUserBgImage")
      public Integer updateUserBgImage(@RequestParam("userBgImage") MultipartFile[] userBgImage,@RequestParam("userAccount") String userAccount){
          Integer count = userService.updateUserBgImage(userBgImage, userAccount);
          return count;
      }

      @PostMapping("/updateUserHeadImage")
      public Integer updateUserHeadImage(@RequestParam("userHeadImage")MultipartFile[] userHeadImage,@RequestParam("userAccount") String userAccount){
          Integer count = userService.updateUserHeadImage(userHeadImage, userAccount);
          return count;
    }

      @PostMapping("/updateUserIp")
    public int updateUserIp(@RequestBody User user){
          int count = userService.updateUserIp(user);
          return count;
      }

      @PostMapping("/updateUserPersonalInformation")
    public Boolean updateUserPersonalInformation(@RequestBody User user){
          return userService.updateUserPersonalInformation(user);
      }

      @PostMapping("/updateUserPrivacy")
    public Integer updateUserPrivacy(@RequestBody User user){
          int count = userService.updateUserPrivacy(user);
          return count;
      }

      @PostMapping("/updateUserToken")
    public Integer updateUserToken(@RequestBody User user){
          int count = userService.updateUserToken(user);
          return count;

      }
}
