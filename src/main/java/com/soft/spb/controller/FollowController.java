package com.soft.spb.controller;


import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.pojo.entity.User;
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
@RequestMapping({"follow", "followed"})
public class FollowController {

    @Autowired
    FollowServiceImpl followServiceImpl;

    @PostMapping("addFollow")
    public ResponseBody getUserCount(@RequestBody Follow follow) {

        boolean followed = followServiceImpl.isFollowed(follow);

        return ResponseBody.builder()
                .code(200)
                .msg(followed ? "已关注，请勿重新关注" : "已添加关注")
                .data("")
                .build();
    }

    @PostMapping("/deleteFollow")
    public ResponseBody deleteFollow(@RequestBody Follow follow) {
        boolean followed = followServiceImpl.deleteFollow(follow);
        return ResponseBody.builder()
                .code(200)
                .msg(followed ? "删除成功" : "数据不存在")
                .data("")
                .build();
    }

    @PostMapping("/queryFollowCount")
    public ResponseBody queryFollowAccount(@RequestBody Follow follow) {
        Integer integer = followServiceImpl.queryFollowAccount(follow);

        return ResponseBody.builder()
                .code(200)
                .msg("获取成功")
                .data(integer)
                .build();
    }

    @PostMapping("/queryFollowList")
    public ResponseBody queryFollowList(@RequestBody Follow follow) {
        List<Follow> followList = followServiceImpl.queryFollowList(follow);
        List<String> data = new ArrayList<>(followList.size());
        for (int i = 0; i < followList.size(); i++) {
            Follow item = followList.get(i);
            data.add(item.getFollowedAccount());
        }
        return ResponseBody.builder()
                .code(200)
                .msg("获取成功")
                .data(data)
                .build();
    }

    @PostMapping("/queryFollowUserList")
    public ResponseBody queryFollowUserList(@RequestBody User user) {

        List<Follow> userList = followServiceImpl.queryFollowUserList(user.getUserAccount());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(userList)
                .build();
    }

    @PostMapping("/queryFollowedCount")
    public ResponseBody queryFollowedCount(@RequestBody Follow follow) {
        Integer count = followServiceImpl.queryFollowedCount(follow);
        return ResponseBody.builder()
                .code(200)
                .msg("获取被关注数")
                .data(count)
                .build();
    }

    @PostMapping("queryFollowedList")
    public ResponseBody queryFollowedList(@RequestBody Follow follow) {
        List<Follow> followedList = followServiceImpl.queryFollowedList(follow);
        List<String> data = new ArrayList<>(followedList.size());
        for (int i = 0; i < followedList.size(); i++) {
            Follow item = followedList.get(i);
            data.add(item.getFollowAccount());
        }
        return ResponseBody.builder()
                .code(200)
                .msg("获取被关注列表")
                .data(data)
                .build();

    }

    @PostMapping("/queryFollowedUserList")
    public ResponseBody queryFollowedUserList(@RequestBody UserDto user) {

        List<Follow> followedUserList = followServiceImpl.queryFollowedUserList(user.getFollowedAccount());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(followedUserList)
                .build();
    }


}
