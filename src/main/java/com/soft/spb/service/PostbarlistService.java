package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Postbarlist;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarlistService extends IService<Postbarlist> {

    Boolean addBar(Postbarlist postbarlist);

    //删除帖子
    Boolean deleteBar(String pbId);

    //获取帖子详细信息
    List<Postbarlist> queryBarDetatilForPbid(Postbarlist postbarlist);

    //根据时间获取帖子列表(无Video)
    List<Postbarlist> queryNoVideoBarListForDate(String date);
}
