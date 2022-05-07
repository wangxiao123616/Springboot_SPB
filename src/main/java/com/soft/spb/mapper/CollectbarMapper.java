package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.pojo.vo.PostbarlistVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface CollectbarMapper extends BaseMapper<Collectbar> {
    /**
     * 2.6.1. 添加收藏帖子
     *
     * @param collectbar
     * @return
     */
    int addCollectBar(Collectbar collectbar);

    /**
     * 2.6.2. 删除收藏帖子
     *
     * @param collectbar
     * @return
     */
    int deleteCollectBar(Collectbar collectbar);

    /**
     * 2.6.3. 获取用户收藏帖子(Full)
     *
     * @param userAccount
     * @return
     */

    List<PostbarlistVo> queryCollectBarFullList(Long id, String userAccount);

    /**
     * 2.6.4. 获取用户收藏帖子(Basic)
     *
     * @param userAccount
     * @return
     */

    List<String> queryCollectBarList(String userAccount);

    List<String> getCollectBarPresenter(String userAccount);
}
