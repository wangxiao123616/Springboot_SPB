package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.PostbarComment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarCommentService extends IService<PostbarComment> {
    Integer addComment(PostbarComment postbarComment);

    Integer deleteComment(PostbarComment postbarComment);

    List<PostbarComment> queryCommentList(PostbarComment postbarComment);

    List<PostbarComment> queryCommentOne(String pbOneId,Integer commentId);


}
