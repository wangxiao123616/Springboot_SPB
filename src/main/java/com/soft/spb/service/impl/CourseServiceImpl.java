package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Course;
import com.soft.spb.mapper.CourseMapper;
import com.soft.spb.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {


}
