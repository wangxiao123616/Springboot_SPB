package com.soft.spb.service;

import com.soft.spb.pojo.entity.Students;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface StudentsService extends IService<Students> {

    Students getStudentsInfo(String userAccount);

    /**
     * 判断用户能否进行注册
     *
     * @param userAccount 学号
     * @return
     */
    Boolean canRegister(String userAccount);
}
