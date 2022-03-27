package com.soft.spb.service;

import com.soft.spb.pojo.entity.Collectbar;
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
public interface CollectbarService extends IService<Collectbar> {
    //2.6.1. 添加收藏帖子
    int addCollectBar(Collectbar collectbar);

    //2.6.2. 删除收藏帖子
    int deleteCollectBar(Collectbar collectbar);

    //2.6.3. 获取用户收藏帖子(Full)
    List<Collectbar> queryCollectBarFullList(String userAccount);

    List<String> queryCollectBarList(Collectbar collectbar);
}
