package com.soft.spb.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTool {
    public static String obtainNowDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(dateTime);
    }

    public static String queryInitDate(String date) {
        if (date == null || date.length() < 2) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return dateTimeFormatter.format(dateTime);
        }
        return date;
    }
}
