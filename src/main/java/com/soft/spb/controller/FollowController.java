package com.soft.spb.controller;


import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.vo.RandomUserVo;
import com.soft.spb.service.FollowService;
import com.soft.spb.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    FollowService followService;

    @PostMapping("addFollow")
    public ResponseBody getUserCount(@RequestBody Follow follow) {

        boolean followed = followService.isFollowed(follow);

        return ResponseBody.builder()
                .code(200)
                .msg(followed ? "已关注，请勿重新关注" : "已添加关注")
                .data("")
                .build();
    }

    @PostMapping("/deleteFollow")
    public ResponseBody deleteFollow(@RequestBody Follow follow) {
        boolean followed = followService.deleteFollow(follow);
        return ResponseBody.builder()
                .code(200)
                .msg(followed ? "删除成功" : "数据不存在")
                .data("")
                .build();
    }

    @PostMapping("/queryFollowCount")
    public Integer queryFollowAccount(@RequestBody Follow follow) {
        Integer integer = followService.queryFollowAccount(follow);

        return integer;
    }

    @PostMapping("/queryFollowList")
    public List<String> queryFollowList(@RequestBody Follow follow) {
        return followService.queryFollowList(follow);
    }

    @PostMapping("/queryFollowUserList")
    public List<Follow> queryFollowUserList(@RequestBody User user) {

        List<Follow> userList = followService.queryFollowUserList(user.getUserAccount());
        return userList;
    }

    @PostMapping("/queryFollowedCount")
    public Integer queryFollowedCount(@RequestBody Follow follow) {
        Integer count = followService.queryFollowedCount(follow);
        return count;
    }

    @PostMapping("queryFollowedList")
    public List<String> queryFollowedList(@RequestBody Follow follow) {
        return followService.queryFollowedList(follow);

    }

    @PostMapping("/queryFollowedUserList")
    public List<Follow> queryFollowedUserList(@RequestBody UserDto user) {
        List<Follow> followedUserList = followService.queryFollowedUserList(user.getFollowedAccount());
        return followedUserList;
    }

    @RequestMapping(value = "/queryRandomUserList", method = RequestMethod.GET)
    public List<RandomUserVo> queryRandomUserList(@RequestParam("num") int num) {
        List<RandomUserVo> followedUserList = followService.queryRundomUserList(num);
        return followedUserList;
    }

}
