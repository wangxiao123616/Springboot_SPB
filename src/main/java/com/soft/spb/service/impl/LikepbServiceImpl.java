package com.soft.spb.service.impl;

import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.pojo.entity.Likepb;
import com.soft.spb.mapper.LikepbMapper;
import com.soft.spb.service.LikepbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
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
public class LikepbServiceImpl extends ServiceImpl<LikepbMapper, Likepb> implements LikepbService {

    private final LikepbMapper likepbMapper;

    private final PostbarlistMapper postbarlistMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addLike(Likepb likepb) {
        try {
            int a = likepbMapper.addLike(likepb);
            int b = postbarlistMapper.updateIncreaseLike(likepb.getPbOneId());
            if (!SqlProcess.transactionalProcess(a, b)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteLike(Likepb likepb) {
        try {
            int a = likepbMapper.deleteLike(likepb);
            int b = 0;
            if (a != 0) {
                b = postbarlistMapper.updateReduceLike(likepb.getPbOneId());
            }
            return SqlProcess.transactionalProcess(a, b);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    @Override
    public List<String> queryLike(Likepb likepb) {
        List<Likepb> likepbs = likepbMapper.queryLike(likepb);
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < likepbs.size(); i++) {
            arr.add(likepbs.get(i).getPbOneId());
        }
        return arr;
    }
}
