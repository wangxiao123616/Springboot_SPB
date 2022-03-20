package com.soft.spb.util;

import lombok.Data;


@Data
public class Response {

    private int errno;

    private String errmsg;

    private Object data;
}
