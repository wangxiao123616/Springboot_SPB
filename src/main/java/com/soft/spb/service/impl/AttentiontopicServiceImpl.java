package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.AttentiontopicMapper;
import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.pojo.vo.AttentiontopicVo;
import com.soft.spb.service.AttentiontopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<AttentiontopicVo> queryAttentionTopic(AttentiontopicDto attentiontopicDto) {
        List<AttentiontopicVo> list = attentiontopicMapper.queryAttentionTopic(attentiontopicDto);
        return list;
    }

    @Override
    public Integer addAttentionTopic(Attentiontopic attentiontopic) {
        Integer count = attentiontopicMapper.addAttentionTopic(attentiontopic);
        return count;

    }

    @Override
    public Integer deleteAttentionTopicById(Attentiontopic attentiontopic) {
        int count = attentiontopicMapper.deleteAttentionTopicById(attentiontopic.getTopicId(), attentiontopic.getUserAccount());
        return count;
    }
}
