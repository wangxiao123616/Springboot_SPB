package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Likepb;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface LikepbMapper extends BaseMapper<Likepb> {


    /**
     * 2.5.1添加点赞
     * @param likepb
     * @return
     */
    int addLike(Likepb likepb);


    /**
     *  2.5.2. 删除点赞
     * @param likepb
     * @return
     */
    int deleteLike(Likepb likepb);


    /**
     * 2.5.3. 获取点赞列表
     * @param likepb
     * @return
     */
    List<Likepb> queryLike(Likepb likepb);


}
