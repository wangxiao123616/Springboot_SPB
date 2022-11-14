package com.soft.spb.service;

import com.soft.spb.pojo.dto.TopicInfoDto;
import com.soft.spb.pojo.entity.Topic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface TopicService extends IService<Topic> {

    List<Topic> querySearchTopicFullList(Long id, String topicName);

    Topic getTopicFull(TopicInfoDto topic);

    List<String> querySearchTopicNameList(String topicName);

    List<Topic> queryHotTopicList();

    List<Topic> querySearchTopicList(String search);
}
