package com.soft.spb.service.impl;

import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.mapper.PostbarCommentMapper;
import com.soft.spb.pojo.vo.PostbarCommentVo;
import com.soft.spb.service.PostbarCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@DubboService
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PostbarCommentServiceImpl extends ServiceImpl<PostbarCommentMapper, PostbarComment> implements PostbarCommentService {

    private final PostbarCommentMapper postbarCommentMapper;

    private final PostbarlistMapper postbarlistMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PostbarCommentVo addComment(PostbarComment postbarComment) {
        PostbarCommentVo postbarCom = new PostbarCommentVo();
        try {
            LocalDateTime now = LocalDateTime.now();
            postbarComment.setCommentDate(now);

            int commentId = postbarCommentMapper.queryMaxCommentId(postbarComment.getPbOneId());
            commentId += 1;
            postbarComment.setCommentId(commentId);

            int ai = postbarCommentMapper.addComment(postbarComment);
            int bi = postbarlistMapper.updateIncreaseComment(postbarComment.getPbOneId());
            if (!SqlProcess.transactionalProcess(ai, bi)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return postbarCom;
            }
            BeanUtils.copyProperties(postbarComment, postbarCom);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return postbarCom;
        }
        return postbarCom;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteComment(PostbarComment postbarComment) {
        try {
            int ai = postbarCommentMapper.deleteComment(postbarComment.getCommentId(), postbarComment.getPbOneId());
            int bi = postbarlistMapper.updateReduceComment(postbarComment.getPbOneId());
            if (!SqlProcess.transactionalProcess(ai, bi)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public List<PostbarCommentVo> queryCommentList(String pbOneId) {
        List<PostbarCommentVo> postbarComments = postbarCommentMapper.queryCommentList(pbOneId);
        return postbarComments;
    }

    @Override
    public List<PostbarComment> queryCommentOne(String pbOneId, Integer commentId) {
        List<PostbarComment> postbarComments = postbarCommentMapper.queryCommentOne(pbOneId, commentId);
        return postbarComments;
    }
}
