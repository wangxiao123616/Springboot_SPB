package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Course;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */

@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public int deleteUserIp(String userAccount) {

        return userMapper.deleteUserIp(userAccount);
    }

    @Override
    public List<Course> querySchoolTable() {

        return userMapper.querySchoolTable();
    }

    @Override
    public List<User> querySearchUser(String search) {

        return  userMapper.querySearchUser(search);
    }

    @Override
    public int updateUserBadgeImage(String userBadge,String userAccount) {
        int count = userMapper.updateUserBadgeImage(userBadge,userAccount);
        return count;
    }
}
