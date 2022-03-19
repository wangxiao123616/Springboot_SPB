package com.soft.spb.controller;


import com.soft.spb.mapper.AppVersionMapper;
import com.soft.spb.pojo.entity.AppVersion;
import com.soft.spb.service.impl.AppVersionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

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
     AppVersionServiceImpl appVersionServiceImpl;

    @GetMapping("/queryList")
    public List<AppVersion>  queryList(){
        List<AppVersion> appVersionListList = appVersionServiceImpl.queryList();
        for (AppVersion appVersion: appVersionListList
                ) {
            System.out.println(appVersion);
        }
        return appVersionListList;
    }



}
