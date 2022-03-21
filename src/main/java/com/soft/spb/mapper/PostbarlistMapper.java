package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Postbarlist;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface PostbarlistMapper extends BaseMapper<Postbarlist> {
    List<Postbarlist> queryAll();

    int addBar(Postbarlist postbarlist);

    //删除数据
    int deleteBar(String pbOneId);

    //获取帖子信息
    List<Postbarlist> queryBarDetatilForPbid(String pbOneId);

    //根据时间获取帖子列表(无Video)
    List<Postbarlist> queryNoVideoBarListForDate(String date);

}
