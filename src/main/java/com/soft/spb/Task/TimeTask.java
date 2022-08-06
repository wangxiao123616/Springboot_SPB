package com.soft.spb.Task;

import com.soft.spb.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author nmy
 * @title: TimeTask
 * @date 2022-08-03 15:38
 */
@Component
public class TimeTask {

    @Autowired
    UserSignService userSignService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void newSignDay(){
        userSignService.initSignDay();
    }

}
