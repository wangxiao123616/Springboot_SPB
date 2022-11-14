package com.soft.spb.controller;


import com.soft.spb.pojo.dto.FollowDto;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Follow;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.vo.FollowListVo;
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

    @GetMapping("/queryFollowUserList")
    public List<FollowListVo> queryFollowUserList(FollowDto followDto) {
        return followService.queryFollowUserList(followDto);
    }

    @GetMapping("/queryFollowedUserList")
    public List<FollowListVo> queryFollowedUserList(FollowDto followDto) {
        return followService.queryFollowedUserList(followDto);
    }

    @RequestMapping(value = "/queryRandomUserList", method = RequestMethod.GET)
    public List<RandomUserVo> queryRandomUserList(@RequestParam("num") int num) {
        List<RandomUserVo> followedUserList = followService.queryRundomUserList(num);
        return followedUserList;
    }

}
