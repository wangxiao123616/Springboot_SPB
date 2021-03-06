package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.pojo.entity.Topic;
import com.soft.spb.pojo.vo.AttentiontopicVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AttentiontopicMapper extends BaseMapper<Attentiontopic> {


    List<String> getAttentionTopPresenter(String userAccount);

    /**
     * 2.13.3. 获取用户关注话题
     * @return
     */
    List<AttentiontopicVo> queryAttentionTopic(AttentiontopicDto attentiontopicDto);

    /**
     * 2.13.1. 添加关注话题
     *
     * @param userAccount
     * @return
     */
    List<String> queryTopicName(String userAccount);

    /**
     * 2.13.1. 添加关注话题
     * @param attentiontopic
     * @return
     */
    int addAttentionTopic(Attentiontopic attentiontopic);

    /**
     * 2.13.2. 删除用户关注话题
     * @param topicId
     * @param userAccount
     * @return
     */
    int deleteAttentionTopicById(Integer topicId,String userAccount);


}
