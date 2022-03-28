package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.core.constant.ResultCode;
import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.mapper.UsersMapper;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.entity.Users;
import com.soft.spb.service.StudentsService;
import com.soft.spb.service.UserService;
import com.soft.spb.service.UsersService;
import com.soft.spb.util.MD5Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    private final UserService userService;
    private final StudentsService studentsService;
    private final UsersMapper usersMapper;
    private final UserMapper userMapper;


    @Override
    public Map<String, Object> login(UserDto userDto) throws ServiceException {
        Users users = getOne(
                Wrappers.<Users>lambdaQuery().eq(Users::getUserAccount, userDto.getUserAccount()));
        // 1. 先判断用户是否存在
        if (users == null) {
            throw new ServiceException(ResultCode.USER_NOT_FOUND);
        }
        // 2. 再判断密码是否正确
        if (MD5Util.verify(userDto.getPassword(), users.getUserPassword())) {
            return userService.getUserInfo(userDto.getUserAccount());
        } else {
            throw new ServiceException(ResultCode.USER_PASSWORD_ERROR);
        }
    }

    @Override
    public Map<String, Object> register(UserDto userDto) throws ServiceException {
        // 1. 先检查用户是否已经存在
        if (getOne(
                Wrappers.<Users>lambdaQuery().eq(Users::getUserAccount, userDto.getUserAccount())
        ) != null) {
            throw new ServiceException(ResultCode.USER_IS_EXIST);
        }
        // 2. 再检测用户是否有权进行注册
        if (!studentsService.canRegister(userDto.getUserAccount())) {
            throw new ServiceException(ResultCode.USER_ACCOUNT_NOT_PERMISSION_TO_REGISTER);
        }
        Users users = Users.builder()
                .userAccount(userDto.getUserAccount())
                .userPassword(MD5Util.md5(userDto.getPassword()))
                .build();
        int usersInsert = usersMapper.insert(users);
        int userInsert = userMapper.insert(User.builder()
                .userAccount(userDto.getUserAccount())
                .userHeadImage("http://tva1.sinaimg.cn/large/008cx1U7gy1h0nd9uybdcj305k05k0sr.jpg")
                .build());
        if (usersInsert != 1 && userInsert != 1) {
            throw new ServiceException(ResultCode.SYSTEM_ERROR);
        }
        return userService.getUserInfo(userDto.getUserAccount());
    }

}
