package com.soft.spb.core.handler;

import com.alibaba.fastjson.JSON;
import com.soft.spb.core.annotation.ResponseResult;
import com.soft.spb.core.component.ResponseResultInterceptor;
import com.soft.spb.util.SPBResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {


    /**
     * 此处如果返回false , 则不执行当前Advice的业务
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        ResponseResult responseResultAnn = (ResponseResult) sra.getRequest()
                .getAttribute(ResponseResultInterceptor.RESPONSE_RESULT_ANN);
        return responseResultAnn != null;
    }


    /**
     * 处理响应的具体方法
     *
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return Object
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {

        if (body instanceof SPBResponse) {
            return body;
        }

        SPBResponse response = new SPBResponse();
        response.setCode(200);
        response.setMsg("成功");
        response.setData(body);

        if (body instanceof String) {
            return JSON.toJSONString(response);
        }

        return response;
    }

}
