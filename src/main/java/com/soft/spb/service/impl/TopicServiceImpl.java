package com.soft.spb.service.impl;

import com.soft.spb.pojo.dto.TopicInfoDto;
import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.mapper.TopicMapper;
import com.soft.spb.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@DubboService
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    private final TopicMapper topicMapper;

    @Override
    public List<Topic> querySearchTopicFullList(Long id, String topicName) {
        if (topicName == null) {
            topicName = "#";
        }
        List<Topic> topicList = topicMapper.querySearchTopicFullList(id, topicName);
        return topicList;
    }

    @Override
    public Topic getTopicFull(TopicInfoDto topic) {
        if (topic.getTopicId() == -1) {
            return topicMapper.getTopicFullByName(topic.getTopicName());
        }
        return topicMapper.getTopicFullById(topic.getTopicId());
    }

    @Override
    public List<String> querySearchTopicNameList(String topicName) {
        List<String> topicNameList = topicMapper.querySearchTopicNameList(topicName);
        return topicNameList;
    }

    @Override
    public List<Topic> queryHotTopicList() {
        return topicMapper.queryHotTopicList();
    }

    @Override
    public List<Topic> querySearchTopicList(String search) {
        return topicMapper.querySearchTopicList(search);
    }
}
