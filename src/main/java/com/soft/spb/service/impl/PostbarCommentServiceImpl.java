package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.mapper.PostbarCommentMapper;
import com.soft.spb.service.PostbarCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PostbarCommentServiceImpl extends ServiceImpl<PostbarCommentMapper, PostbarComment> implements PostbarCommentService {

    private final PostbarCommentMapper postbarCommentMapper;
    @Override
    public Integer deleteComment(PostbarComment postbarComment) {
      int count = postbarCommentMapper.deleteComment(postbarComment.getCommentId(),postbarComment.getPbOneId());

        return count;
    }

    @Override
    public List<PostbarComment> queryCommentList(PostbarComment postbarComment) {
        List<PostbarComment> postbarComments = postbarCommentMapper.queryCommentList(postbarComment.getPbOneId());
        return postbarComments;
    }

    @Override
    public List<PostbarComment> queryCommentOne(String pbOneId,Integer commentId) {
        List<PostbarComment> postbarComments = postbarCommentMapper.queryCommentOne(pbOneId,commentId);
        return postbarComments;
    }
}
