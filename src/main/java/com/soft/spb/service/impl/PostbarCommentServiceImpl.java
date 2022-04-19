package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.mapper.PostbarCommentMapper;
import com.soft.spb.pojo.vo.PostbarCommentVo;
import com.soft.spb.service.PostbarCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Integer addComment(PostbarComment postbarComment) {
        LocalDateTime now  = LocalDateTime.now();
        postbarComment.setCommentDate(now);
        int count= postbarCommentMapper.addComment(postbarComment);
        return count;
    }

    @Override
    public Integer deleteComment(PostbarComment postbarComment) {
      int count = postbarCommentMapper.deleteComment(postbarComment.getCommentId(),postbarComment.getPbOneId());

        return count;
    }

    @Override
    public List<PostbarCommentVo> queryCommentList(String pbOneId) {
        List<PostbarCommentVo> postbarComments = postbarCommentMapper.queryCommentList(pbOneId);
        return postbarComments;
    }

    @Override
    public List<PostbarComment> queryCommentOne(String pbOneId,Integer commentId) {
        List<PostbarComment> postbarComments = postbarCommentMapper.queryCommentOne(pbOneId,commentId);
        return postbarComments;
    }
}
