package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Attentiontopic;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AttentiontopicMapper extends BaseMapper<Attentiontopic> {

    List<String> getAttentionTopPresenter(String userAccount);

}
