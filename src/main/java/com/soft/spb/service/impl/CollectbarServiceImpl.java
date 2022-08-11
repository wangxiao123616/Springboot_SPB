package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.CollectbarMapper;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.service.CollectbarService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@DubboService
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CollectbarServiceImpl extends ServiceImpl<CollectbarMapper, Collectbar> implements CollectbarService {

    private final CollectbarMapper collectbarMapper;

    @Override
    public boolean addCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.addCollectBar(collectbar);
        return count > 0;
    }

    @Override
    public boolean deleteCollectBar(Collectbar collectbar) {
        int count = collectbarMapper.deleteCollectBar(collectbar);
        return count > 0;
    }

    @Override
    public List<PostbarlistVo> queryCollectBarFullList(Long id, String userAccount) {
        List<PostbarlistVo> postbarlistVos = collectbarMapper.queryCollectBarFullList(id, userAccount);
        postbarlistVos.remove(null);
        return postbarlistVos;
    }

    @Override
    public List<String> getCollectBarPresenter(String userAccount) {
        return collectbarMapper.getCollectBarPresenter(userAccount);
    }
}

