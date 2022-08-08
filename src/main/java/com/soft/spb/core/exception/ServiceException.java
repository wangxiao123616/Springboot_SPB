package com.soft.spb.core.exception;

import com.soft.spb.core.constant.ResultCode;

import java.io.Serializable;


public class ServiceException extends RuntimeException implements Serializable {

    private int code;

    private Object attach;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ServiceException() {
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.message());
        this.code = resultCode.code();
    }

    public ServiceException attach(Object attach) {
        this.attach = attach;
        return this;
    }
}
