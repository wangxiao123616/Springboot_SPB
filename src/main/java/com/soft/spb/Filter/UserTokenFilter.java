package com.soft.spb.Filter;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.soft.spb.core.constant.ResultCode;
import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.core.handler.GlobalExceptionHandler;
import com.soft.spb.pojo.dto.SUserDetails;
import com.soft.spb.util.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author nmy
 * @title: UserTokenFilter
 * @date 2022-08-06 20:57
 */
@Component
public class UserTokenFilter extends OncePerRequestFilter {

    private final String secret = "${token.secret}";

    @Autowired
    RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        String userData;
        try{
            Claims body = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
            userData = (String) body.get("login_user_key");
            if (StringUtils.isEmpty(userData) || userData.length() != 9){
                sendResponse(response);
                return;
            }
        }catch (Exception e){
            sendResponse(response);
            return;
        }

        String redisKey = "login:web:" + userData;
        SUserDetails s = redisUtil.getEasyObject(redisKey);
        if (Objects.isNull(s)){
            sendResponse(response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(s,
                null,
                null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private void sendResponse(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSON.toJSONString(new GlobalExceptionHandler().handleException(new ServiceException(ResultCode.USER_TOKEN_EXPIRES))));
    }
}
