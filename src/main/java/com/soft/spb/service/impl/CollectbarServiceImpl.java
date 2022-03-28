package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.CollectbarMapper;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.service.CollectbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CollectbarServiceImpl extends ServiceImpl<CollectbarMapper, Collectbar> implements CollectbarService {

    private final CollectbarMapper collectbarMapper;

    @Override

    public int addCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.addCollectBar(collectbar);
        return count;
    }

    @Override
    public int deleteCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.deleteCollectBar(collectbar);
        return count;
    }

    @Override
    public List<Collectbar> queryCollectBarFullList(String userAccount) {
        List<Collectbar> collectbars = collectbarMapper.queryCollectBarFullList(userAccount);
        return collectbars;
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

