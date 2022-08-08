package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.core.constant.ResultCode;
import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.mapper.UsersMapper;
import com.soft.spb.pojo.dto.SUserDetails;
import com.soft.spb.pojo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author nmy
 * @title: UserDetailServiceImpl
 * @date 2022-08-06 13:25
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //传入用户名
        //数据库查找该用户
        Users users = getOne(
                Wrappers.<Users>lambdaQuery().eq(Users::getUserAccount, username));
        if (users != null) {
            return new SUserDetails(users);
        }else {
            throw new ServiceException(ResultCode.USER_NOT_FOUND);
        }
    }
}
