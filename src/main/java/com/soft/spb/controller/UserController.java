package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.vo.UserVo;
import com.soft.spb.service.UserService;
import com.soft.spb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
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

    @GetMapping("/getUserInfo/{account}")
    public Map<String, Object> getUserInfo(@PathVariable String account) {
        return userService.getUserInfo(account);
    }

    @GetMapping("/getUserInfo")
    public Map<String, Object> getUserInfo() {
        return userService.getUserInfo();
    }

//    @PostMapping("/updateUserBadgeImage")
//    public int updateUserBadgeImage(@RequestBody User user) {
//        int count = userService.updateUserBadgeImage(user.getUserBadge(), user.getUserAccount());
//        return count;
//
//    }
//
//    @PostMapping("/updateUserBgImage")
//    public Integer updateUserBgImage(@RequestParam("userBgImage") MultipartFile[] userBgImage, @RequestParam("userAccount") String userAccount) {
//        Integer count = userService.updateUserBgImage(userBgImage, userAccount);
//        return count;
//    }
//
//    @PostMapping("/updateUserHeadImage")
//    public Integer updateUserHeadImage(@RequestParam("userHeadImage") MultipartFile[] userHeadImage, @RequestParam("userAccount") String userAccount) {
//        Integer count = userService.updateUserHeadImage(userHeadImage, userAccount);
//        return count;
//    }

    @PostMapping("/updateUserPersonalInformation")
    public Boolean updateUserPersonalInformation(@RequestBody User user) {
        return userService.updateUserPersonalInformation(user);
    }

    @GetMapping("/querySearchUser")
    public List<UserVo> querySearchUser(@RequestParam("search") String search){
        return userService.querySearchUser(search);
    }
}
