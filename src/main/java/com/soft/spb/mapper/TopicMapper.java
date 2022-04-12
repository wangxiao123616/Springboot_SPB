package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Topic;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface TopicMapper extends BaseMapper<Topic> {

    /**
     * 2.14.1. 获取随机话题列表
     * @param topic
     * @return
     */
    List<Topic> queryRundomTopicFullList(int min,int max);

    /**
     * 2.14.2. 获取搜索话题详细列表
     * @param topicName
     * @return
     */
    List<Topic> querySearchTopicFullList(String topicName);

    Topic getTopicFullById(int id);

    Topic getTopicFullByName(String name);

    /**
     * 2.14.3. 搜索话题名列表
     * @return
     */
    List<Topic> querySearchTopicNameList(String topicName);

    /**
     * 2.14.4. 获取话题详细信息
     * @param topicName
     * @return
     */
    List<Topic> queryTopicFull(String topicName);

    /**
     * 2.14.5. 获取话题名列表
     * @return
     */
    List<String> queryTopicNameList();

    /**
     * 2.14.5. 获取热点话题
     * @return
     */
    List<Topic> queryHotTopicList();
}
