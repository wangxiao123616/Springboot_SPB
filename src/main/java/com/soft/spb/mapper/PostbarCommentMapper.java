package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.PostbarComment;
import com.soft.spb.pojo.vo.PostbarCommentVo;
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
     * @Description: 获取楼层
     * @Param: [pbId]
     * @return: int
     * @Author: nmy
     * @Date: 2022-05-03 21:20
     */
    int queryMaxCommentId(@Param("pb_one_id") String pbId);

    /**
     * 2.12.1. 添加评论
     * @param postbarComment
     * @return
     */
    int addComment(PostbarComment postbarComment);

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
    List<PostbarCommentVo> queryCommentList(String pbOneId);

}
