package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.pojo.dto.UpdatePwdDto;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Users;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface UsersService extends IService<Users> {

    Map<String, Object> login(UserDto userDto) throws ServiceException;

    boolean logout(UserDto userDto) throws ServiceException;

    Map<String, Object> register(UserDto userDto) throws ServiceException;

    Boolean updatePwd(UpdatePwdDto updatePwd) throws ServiceException;

}
