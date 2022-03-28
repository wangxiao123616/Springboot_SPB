package com.soft.spb.controller;

import com.soft.spb.service.impl.DateTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
public class DateTimeController {

    @Autowired
    DateTimeServiceImpl dateTimeServiceImpl;

    @PostMapping("/dateTime")
    public String dateTime(){
        String dateTime = dateTimeServiceImpl.getDateTime();
        return dateTime;
    }

}
