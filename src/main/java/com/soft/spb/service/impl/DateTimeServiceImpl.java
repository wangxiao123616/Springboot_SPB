package com.soft.spb.service.impl;

import com.soft.spb.service.dateTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DateTimeServiceImpl implements dateTimeService {


    @Override
    public String getDateTime() {
        String ddate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return ddate;
    }
}
