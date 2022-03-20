package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.service.impl.FollowServiceImpl;
import com.soft.spb.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    FollowServiceImpl followServiceImpl;

    @PostMapping("/addFollow")
    public ResponseBody getUserCount(@RequestBody Follow follow) {
        
        boolean followed = followServiceImpl.isFollowed(follow);

        return ResponseBody.builder()
                .code(200)
                .msg(followed ? "已关注，请勿重新关注" : "已添加关注")
                .data("")
                .build();
    }

    @PostMapping("/deleteFollow")
    public ResponseBody deleteFollow(@RequestBody Follow follow){
      boolean followed = followServiceImpl.deleteFollow(follow);
      return ResponseBody.builder()
                         .code(100)
                         .msg(followed?"删除成功":"数据不存在")
                         .data("")
                         .build();
    }

}
