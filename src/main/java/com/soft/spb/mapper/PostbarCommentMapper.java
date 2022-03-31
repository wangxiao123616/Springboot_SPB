package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.PostbarComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarCommentMapper extends BaseMapper<PostbarComment> {

    /**
     * 2.12.2. 删除评论
     * @param commentId
     * @param pbOneId
     * @return
     */
    int deleteComment(@Param("commentId") Integer  commentId,@Param("pbOneId") String pbOneId);

    /**
     * 2.12.3. 获取评论列表
     * @param pbOneId
     * @return
     */
    List<PostbarComment> queryCommentList(String pbOneId);

    /**
     * 2.12.4. 获取通知评论
     * @param pbOneId
     * @param commentId
     * @return
     */
    List<PostbarComment> queryCommentOne(String pbOneId,Integer commentId);



}
