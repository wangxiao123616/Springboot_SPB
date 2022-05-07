package com.soft.spb.service.impl;

import com.soft.spb.pojo.dto.TopicInfoDto;
import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.mapper.TopicMapper;
import com.soft.spb.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    private final TopicMapper topicMapper;

    @Override
    public List<Topic> queryRundomTopicFullList() {
        int min = (int) (Math.random() * 200) + 100;
        int max = (int) (Math.random() * 500) + 500;
        List<Topic> topicList = topicMapper.queryRundomTopicFullList(min, max);
        return topicList;
    }

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
    public List<Topic> queryTopicFull(String topicName) {
        List<Topic> topicList = topicMapper.queryTopicFull(topicName);
        return topicList;
    }

    @Override
    public List<String> queryTopicNameList() {
        List<String> topicNameList = topicMapper.queryTopicNameList();
        return topicNameList;
    }

    @Override
    public List<Topic> queryHotTopicList() {
        return topicMapper.queryHotTopicList();
    }
}
