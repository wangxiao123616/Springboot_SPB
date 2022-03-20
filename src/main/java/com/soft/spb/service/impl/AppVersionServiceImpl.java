package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.AppVersionMapper;
import com.soft.spb.pojo.entity.AppVersion;
import com.soft.spb.service.AppVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements AppVersionService {

   private final AppVersionMapper appVersionMapper;

    @Override
    public AppVersion getAppVersion(Integer versionCode) {
        return appVersionMapper.getAppVersion();
    }

  
}
