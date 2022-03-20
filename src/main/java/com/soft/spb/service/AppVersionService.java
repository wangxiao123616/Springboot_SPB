package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.AppVersion;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */

public interface AppVersionService extends IService<AppVersion> {
     AppVersion getAppVersion(Integer versionCode);


}
