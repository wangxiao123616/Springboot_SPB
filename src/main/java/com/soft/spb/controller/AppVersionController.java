package com.soft.spb.controller;


import com.soft.spb.pojo.entity.AppVersion;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/isVersion")
    public RequestBody getVersionUpdate(@RequestBody AppVersion appVersion) {


        return null;
    }

}
