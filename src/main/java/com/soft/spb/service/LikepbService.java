package com.soft.spb.service;

import com.soft.spb.pojo.entity.Likepb;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface LikepbService extends IService<Likepb> {
    //2.5.1. 添加点赞
    int addLike(Likepb likepb);

    //2.5.2. 删除点赞
    int deleteLike(Likepb likepb);

    //2.5.3. 获取点赞列表
    List<String> queryLike(Likepb likepb);
}
