package com.soft.spb.controller;


import com.soft.spb.pojo.entity.UserSign;
import com.soft.spb.service.impl.UserSignServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    UserSignServiceImpl userSignServiceImpl;

    @PostMapping("/queryUserBadge")
    public List<UserSign> queryUserBadge(@RequestBody UserSign userSign) {
        System.out.println(userSign);
        List<UserSign> userSigns = userSignServiceImpl.queryUserBadge(userSign.getUserAccount());
        return userSigns;
    }

    @PostMapping("/queryUserSign")
    public List<UserSign> queryUserSign(@RequestBody UserSign userSign) {
        List<UserSign> userSigns = userSignServiceImpl.queryUserSign(userSign.getUserAccount());
        return userSigns;
    }

    @PostMapping("/updateSignCoin")
    public Integer updateSignCoin(@RequestBody UserSign userSign) {
        int count = userSignServiceImpl.updateSignCoin(userSign);
        return count;

    }
      @PostMapping("/updateSignDay")
    public Integer updateSignDay(@RequestBody UserSign userSign){
          int count = userSignServiceImpl.updateSignDay(userSign);
          return count;

      }

      @PostMapping("/updateSignDayAndRight")
    public Integer updateSignDayAndRight(@RequestBody UserSign userSign){
          Integer count = userSignServiceImpl.updateSignDayAndRight(userSign);
          return count;

      }

      @PostMapping("/updateSignDayAndRightAndCoin")
    public Integer updateSignDayAndRightAndCoin(@RequestBody UserSign userSign){
          Integer coin = userSignServiceImpl.updateSignDayAndRightAndCoin(userSign);
          return coin;
      }

      @PostMapping("/updateSignLikeBadge")
    public  Integer updateSignLikeBadge(@RequestBody UserSign userSign){
          Integer count = userSignServiceImpl.updateSignLikeBadge(userSign);
          return count;
      }

      @PostMapping("/updateSignRight")
    public Integer updateSignRight(@RequestBody UserSign userSign){

          Integer count = userSignServiceImpl.updateSignRight(userSign);
          return count;

      }

      @PostMapping("/updateSignStarBadge")
    public Integer updateSignStarBadge(@RequestBody UserSign userSign){
          int count = userSignServiceImpl.updateSignStarBadge(userSign);
          return count;

      }

      @PostMapping("/updateSignTaskBadge")
    public Integer updateSignTaskBadge(@RequestBody UserSign userSign){
          int count = userSignServiceImpl.updateSignTaskBadge(userSign);
          return count;

      }

}
