package com.soft.spb.controller;


import com.soft.spb.core.annotation.ResponseResult;
import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@ResponseResult
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/deleteUserIp")
    public Integer addCollectBar(@RequestBody User user) {
        int count = userServiceImpl.deleteUserIp(user.getUserAccount());
        return count;
    }

      @PostMapping("/querySchoolTable")
    public List<Course> querySchoolTable(){
        return userServiceImpl.querySchoolTable();
      }

      @PostMapping("/querySearchUser/{search}")
    public List<User> querySearchUser(@PathVariable String search){
          List<User> users = userServiceImpl.querySearchUser(search);
         return users;
      }
      @PostMapping("/updateUserBadgeImage")
    public int updateUserBadgeImage(@RequestBody User user){
          int count = userServiceImpl.updateUserBadgeImage(user.getUserBadge(),user.getUserAccount());
          return count;

      }
}
