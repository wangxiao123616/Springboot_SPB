package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.CollectbarMapper;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.service.CollectbarService;
import com.soft.spb.util.DateTool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CollectbarServiceImpl extends ServiceImpl<CollectbarMapper, Collectbar> implements CollectbarService {

    private final CollectbarMapper collectbarMapper;

    @Override

    public Integer addCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.addCollectBar(collectbar);
        return count;
    }

    @Override
    public Integer deleteCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.deleteCollectBar(collectbar);
        return count;
    }

    @Override
    public List<PostbarlistVo> queryCollectBarFullList(Long id, String userAccount) {
        return collectbarMapper.queryCollectBarFullList(id, userAccount);
    }

    @Override
    public List<String> queryCollectBarList(Collectbar collectbar) {
        List<String> collectbars = collectbarMapper.queryCollectBarList(collectbar.getUserAccount());
        return collectbars;
    }

    @Override
    public List<String> getCollectBarPresenter(String userAccount) {
        return collectbarMapper.getCollectBarPresenter(userAccount);
    }
}

