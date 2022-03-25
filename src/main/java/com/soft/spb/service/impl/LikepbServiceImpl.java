package com.soft.spb.service.impl;

import com.soft.spb.pojo.entity.Likepb;
import com.soft.spb.mapper.LikepbMapper;
import com.soft.spb.service.LikepbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class LikepbServiceImpl extends ServiceImpl<LikepbMapper, Likepb> implements LikepbService {

    private final LikepbMapper likepbMapper;

    @Override
    public int addLike(Likepb likepb) {
        int count = likepbMapper.addLike(likepb);
        return count;
    }

    @Override
    public int deleteLike(Likepb likepb) {
        int count = likepbMapper.deleteLike(likepb);
        return count;
    }

    @Override
    public List<String> queryLike(Likepb likepb) {
        List<Likepb> likepbs = likepbMapper.queryLike(likepb);
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < likepbs.size(); i++) {
         arr.add(likepbs.get(i).getPbOneId()) ;
        }
        return arr;
    }
}
