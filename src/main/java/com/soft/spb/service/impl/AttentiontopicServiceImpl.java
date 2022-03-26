package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.mapper.AttentiontopicMapper;
import com.soft.spb.service.AttentiontopicService;
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
public class AttentiontopicServiceImpl extends ServiceImpl<AttentiontopicMapper, Attentiontopic> implements AttentiontopicService {

    private final AttentiontopicMapper attentiontopicMapper;


    @Override
    public List<String> getAttentionTopPresenter(String userAccount) {
        return attentiontopicMapper.getAttentionTopPresenter(userAccount);
    }
}
