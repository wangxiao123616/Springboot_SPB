package com.soft.spb.service;

import com.soft.spb.pojo.entity.AppVersion;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AppVersionService extends IService<AppVersion> {

     RequestBody getVersionUpdate();

}
