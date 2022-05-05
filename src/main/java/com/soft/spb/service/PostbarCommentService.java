package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.pojo.vo.PostbarCommentVo;

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
    PostbarCommentVo addComment(PostbarComment postbarComment);

    Boolean deleteComment(PostbarComment postbarComment);

    List<PostbarCommentVo> queryCommentList(String pbOneId);

    List<PostbarComment> queryCommentOne(String pbOneId,Integer commentId);


}
