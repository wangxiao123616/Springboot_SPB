package com.soft.spb.util;

import lombok.Data;


@Data
public class SPBResponse {

    private int code;

    private String msg;

    private Object data;
}
