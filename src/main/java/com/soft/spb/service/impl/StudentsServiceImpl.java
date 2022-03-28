package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft.spb.pojo.entity.Students;
import com.soft.spb.mapper.StudentsMapper;
import com.soft.spb.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

    @Override
    public Students getStudentsInfo(String userAccount) {
        return getOne(Wrappers.<Students>lambdaQuery().eq(Students::getStuNum, userAccount));
    }

    @Override
    public Boolean canRegister(String userAccount) {
        Students students = getOne(Wrappers.<Students>lambdaQuery().eq(Students::getStuNum, userAccount));
        return students != null;
    }
}
