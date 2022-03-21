package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.PostbarlistMapper;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.service.PostbarlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class PostbarlistServiceImpl extends ServiceImpl<PostbarlistMapper, Postbarlist> implements PostbarlistService {
    private final PostbarlistMapper postbarlistMapper;

    @Override
    public Boolean addBar(Postbarlist postbarlist) {
        return true;
    }

    @Override
    public Boolean deleteBar(String pbId) {

        List<Postbarlist> postbarlists = postbarlistMapper.queryAll();
        boolean isBar = false;

        for (int i = 0; i < postbarlists.size(); i++) {

            Postbarlist p = postbarlists.get(i);

            if (p.getPbOneId().equals(pbId)) {
                isBar = true;
                postbarlistMapper.deleteBar(p.getPbOneId());
                break;
            }

        }
        return isBar;
    }

    @Override
    public List<Postbarlist> queryBarDetatilForPbid(Postbarlist postbarlist) {
        List<Postbarlist> detatil = postbarlistMapper.queryBarDetatilForPbid(postbarlist.getPbOneId());
        return detatil;
    }

    @Override
    public List<Postbarlist> queryNoVideoBarListForDate(String date) {
        String dateStirng = null;
        if (date.length() < 2) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateStirng = now.format(dateFormat);
        } else {
            dateStirng = date;
        }
        System.out.println(dateStirng);
        List<Postbarlist> items = postbarlistMapper.queryNoVideoBarListForDate(dateStirng);
        return items;
    }


}
