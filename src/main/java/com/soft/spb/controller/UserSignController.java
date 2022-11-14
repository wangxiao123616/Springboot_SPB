package com.soft.spb.controller;


import com.soft.spb.pojo.entity.UserSign;
import com.soft.spb.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/userSign")
public class UserSignController {
    @Autowired
    UserSignService userSignService;

    //    @PostMapping("/queryUserBadge")
//    public UserSign queryUserBadge(@RequestBody UserSign userSign) {
//        UserSign userSigns = userSignService.queryUserBadge(userSign.getUserAccount());
//        return userSigns;
//    }
//
    @GetMapping("/queryUserSign")
    public UserSign queryUserSign(@RequestParam("userAccount") String userAccount) {
        UserSign userSigns = userSignService.queryUserSign(userAccount);
        return userSigns;
    }

    @PostMapping("/updateSignDayAndRightAndCoin")
    public Boolean updateSignDayAndRightAndCoin(@RequestBody UserSign userSign) {
        Boolean coin = userSignService.updateSignDayAndRightAndCoin(userSign);
        return coin;
    }

    @PostMapping("/updateSignLikeBadge")
    public Boolean updateSignLikeBadge(@RequestBody UserSign userSign) {
        return userSignService.updateSignLikeBadge(userSign);
    }

    @PostMapping("/updateSignStarBadge")
    public Integer updateSignStarBadge(@RequestBody UserSign userSign) {
        int count = userSignService.updateSignStarBadge(userSign);
        return count;
    }

    @PostMapping("/updateSignTaskBadge")
    public Boolean updateSignTaskBadge(@RequestBody UserSign userSign) {
        return userSignService.updateSignTaskBadge(userSign);
    }
}
