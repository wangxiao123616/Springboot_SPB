package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Collectbar;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface CollectbarService extends IService<Collectbar> {

    List<String> getCollectBarPresenter(String userAccount);
}
