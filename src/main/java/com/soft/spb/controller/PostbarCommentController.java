package com.soft.spb.controller;


import com.soft.spb.pojo.dto.PostbarCommentDto;
import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.pojo.vo.PostbarCommentVo;
import com.soft.spb.service.PostbarCommentService;
import com.soft.spb.service.impl.PostbarCommentServiceImpl;
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
@RestController
@RequestMapping("/postbarComment")
public class PostbarCommentController {

    @Autowired
    PostbarCommentService postbarCommentService;

    @PostMapping("/addComment")
    public PostbarCommentVo addComment(@RequestBody PostbarComment postbarComment){
        return postbarCommentService.addComment(postbarComment);
    }

    @PostMapping("/deleteComment")
    public Boolean deleteComment(@RequestBody PostbarComment postbarComment){
        return postbarCommentService.deleteComment(postbarComment);
    }

    @GetMapping("/queryCommentList/{pbOneId}")
    public List<PostbarCommentVo> queryCommentList(@PathVariable String pbOneId){
        List<PostbarCommentVo> postbarComments = postbarCommentService.queryCommentList(pbOneId);
        return postbarComments;
    }
}
