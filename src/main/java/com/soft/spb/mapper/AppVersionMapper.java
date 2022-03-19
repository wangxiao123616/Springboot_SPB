package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.AppVersion;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AppVersionMapper extends BaseMapper<AppVersion> {

    AppVersion getAppVersion();

}
