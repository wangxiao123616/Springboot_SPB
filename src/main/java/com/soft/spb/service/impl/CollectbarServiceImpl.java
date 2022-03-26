package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.mapper.CollectbarMapper;
import com.soft.spb.service.CollectbarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CollectbarServiceImpl extends ServiceImpl<CollectbarMapper, Collectbar> implements CollectbarService {

    private  final CollectbarMapper collectbarMapper;

    @Override
    public List<String> getCollectBarPresenter(String userAccount) {
        return collectbarMapper.getCollectBarPresenter(userAccount);
    }
}
