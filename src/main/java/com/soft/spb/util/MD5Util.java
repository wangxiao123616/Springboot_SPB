package com.soft.spb.util;

import org.springframework.util.DigestUtils;


public class MD5Util {
    
    public static String md5(String text) {
        return DigestUtils.md5DigestAsHex((text + "spb").getBytes());
    }

    
    public static boolean verify(String text, String md5) {
        
        String md5Text = md5(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }
}
