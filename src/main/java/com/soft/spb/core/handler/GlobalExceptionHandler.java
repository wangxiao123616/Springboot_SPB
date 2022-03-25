package com.soft.spb.core.handler;

import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.util.SPBResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description
 * @Author xunmi
 * @Date 2022/3/20 16:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public SPBResponse handleException(ServiceException e) {
        SPBResponse response = new SPBResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMessage());
        return response;
    }

//    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SPBResponse handleException(Exception e) {
        Throwable ex = e;
        if (e instanceof InvocationTargetException) {
            InvocationTargetException proxy = (InvocationTargetException) e;
            Throwable targetException = proxy.getTargetException();
            ex = targetException;
        }
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.error("DING-[网关][{}][{}] 系统未知异常", MDC.get("RequestNo"), sra.getRequest().getRequestURI(), ex);
        SPBResponse SPBResponse = new SPBResponse();
        SPBResponse.setCode(1000);
        SPBResponse.setMsg("系统未知异常");
        return SPBResponse;
    }
}
