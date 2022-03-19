package com.soft.spb.controller;


import com.soft.spb.pojo.entity.AppVersion;
import com.soft.spb.service.AppVersionService;
import com.soft.spb.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/appVersion")
public class AppVersionController {

    @Autowired
    AppVersionService appVersionService;

    @PostMapping("/isVersion")
    public ResponseBody getVersionUpdate(@RequestBody AppVersion appVersion) {
        Integer userVersionCode = appVersion.getVersionCode();
        AppVersion currentAppVersion = appVersionService.getAppVersion(userVersionCode);
        Integer code = currentAppVersion.getVersionCode();
        List<Object> data = new ArrayList<>(2);
        if (Objects.equals(userVersionCode, code)) {
           data.add("已是最新版本，无需更新");
        } else {
            data.add("有新版本，请前往更新");
        }
        data.add(currentAppVersion);
        return ResponseBody.builder()
                .code(200)
                .msg("成功")
                .data(data)
                .build();
    }
}
