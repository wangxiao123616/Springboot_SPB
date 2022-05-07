package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.pojo.vo.AttentiontopicVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface AttentiontopicService extends IService<Attentiontopic> {

    List<String> getAttentionTopPresenter(String userAccount);

    List<AttentiontopicVo> queryAttentionTopic(AttentiontopicDto attentiontopicDto);

    Boolean  addAttentionTopic(Attentiontopic attentiontopic);

    Boolean deleteAttentionTopicById(Attentiontopic attentiontopic);

}
