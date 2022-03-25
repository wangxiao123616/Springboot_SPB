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
     //2.5.1添加点赞(需补充，未完成)
     int addLike(Likepb likepb);

     //2.5.2. 删除点赞
     int deleteLike(Likepb likepb);

     //2.5.3. 获取点赞列表
     List<Likepb>queryLike(Likepb likepb);


}
