package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.AttentiontopicMapper;
import com.soft.spb.mapper.TopicMapper;
import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.pojo.vo.AttentiontopicVo;
import com.soft.spb.service.AttentiontopicService;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
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
public class AttentiontopicServiceImpl extends ServiceImpl<AttentiontopicMapper, Attentiontopic> implements AttentiontopicService {

    private final AttentiontopicMapper attentiontopicMapper;

    private final TopicMapper topicMapper;

    @Override
    public List<String> getAttentionTopPresenter(String userAccount) {
        return attentiontopicMapper.getAttentionTopPresenter(userAccount);
    }

    @Override
    public List<AttentiontopicVo> queryAttentionTopic(AttentiontopicDto attentiontopicDto) {
        List<AttentiontopicVo> list = attentiontopicMapper.queryAttentionTopic(attentiontopicDto);
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addAttentionTopic(Attentiontopic attentiontopic) {
        LocalDateTime localDateTime = LocalDateTime.now();
        attentiontopic.setTopicDate(localDateTime);
        try {
            int i = attentiontopicMapper.addAttentionTopic(attentiontopic);
            int i1 = topicMapper.updateIncreaseAttention(attentiontopic.getTopicId());
            if (SqlProcess.transactionalProcess(i, i1)) {
                return true;
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteAttentionTopicById(Attentiontopic attentiontopic) {
        try {
            int count = attentiontopicMapper.deleteAttentionTopicById(attentiontopic.getTopicId(), attentiontopic.getUserAccount());
            int i1 = topicMapper.updateReduceAttention(attentiontopic.getTopicId());
            if (SqlProcess.transactionalProcess(count, i1)) {
                return true;
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
