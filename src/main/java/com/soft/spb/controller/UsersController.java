package com.soft.spb.controller;


import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Users;
import com.soft.spb.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UsersService usersService;

    @PostMapping("login")
    Map<String, Object>  login(@RequestBody UserDto userDto) throws ServiceException {
        return usersService.login(userDto);
    }

    @PostMapping("register")
    Map<String, Object> register(@RequestBody UserDto userDto) throws ServiceException {
        return usersService.register(userDto);
    }

}
