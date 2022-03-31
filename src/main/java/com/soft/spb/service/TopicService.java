package com.soft.spb.service;

import com.soft.spb.pojo.entity.Topic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface TopicService extends IService<Topic> {
    /**
     * 2.14.1. 获取随机话题列表
     * @return
     */
    List<Topic> queryRundomTopicFullList( );

    List<Topic> querySearchTopicFullList(String topicName);

    List<Topic> querySearchTopicNameList(String topicName);

    List<Topic> queryTopicFull(String topicName);

    List<String> queryTopicNameList( );

}
