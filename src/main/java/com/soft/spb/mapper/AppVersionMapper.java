package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.AppVersion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AppVersionMapper extends BaseMapper<AppVersion> {

    String getAppVersion();

}
