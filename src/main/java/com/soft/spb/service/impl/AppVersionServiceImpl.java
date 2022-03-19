package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.AppVersion;
import com.soft.spb.mapper.AppVersionMapper;
import com.soft.spb.service.AppVersionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements AppVersionService {

    @Override
    public RequestBody getVersionUpdate() {


        return null;
    }
}
