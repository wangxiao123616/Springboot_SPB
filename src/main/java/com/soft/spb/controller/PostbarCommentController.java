package com.soft.spb.controller;


import com.soft.spb.pojo.dto.PostbarCommentDto;
import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.service.impl.PostbarCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    PostbarCommentServiceImpl postbarCommentServiceImpl;

    @PostMapping("/addComment")
    public Integer addComment(@RequestBody PostbarComment postbarComment){
        Integer count = postbarCommentServiceImpl.addComment(postbarComment);
        return count;
    }

    @PostMapping("/deleteComment")
    public Integer deleteComment(@RequestBody PostbarComment postbarComment){

        Integer count = postbarCommentServiceImpl.deleteComment(postbarComment);
        return count;

    }

    @PostMapping("/queryCommentList")
    public List<PostbarComment> queryCommentList(@RequestBody PostbarComment postbarComment){
        List<PostbarComment> postbarComments = postbarCommentServiceImpl.queryCommentList(postbarComment);
        return postbarComments;
    }

    @PostMapping("/queryCommentOne")
    public  List<PostbarComment> queryCommentOne(@RequestBody PostbarCommentDto postbarCommentDto){
        List<PostbarComment> postbarComments = postbarCommentServiceImpl.queryCommentOne(postbarCommentDto.getPbOneId(),postbarCommentDto.getCommentId());
        return postbarComments;

    }

}
