package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.DiaryMapper;
import com.soft.spb.pojo.entity.Diary;
import com.soft.spb.service.DiaryService;
import com.soft.spb.util.AliOssUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
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
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {

    private final DiaryMapper diaryMapper;

    @Override
    public int addDiary(Diary diary, MultipartFile[] sourceFiles) {
        LocalDateTime now = LocalDateTime.now();
        diary.setDiaDate(now);
        List<String> urlList = AliOssUtil.upload(sourceFiles);
        String imgUrl = urlList.get(0);
              imgUrl.substring(51);
        diary.setDiaImage(imgUrl);
        int count = diaryMapper.addDiary(diary);
        return count;
    }

    @Override
    public int deleteDiary(Diary diary) {
        int count = diaryMapper.deleteDiary(diary);
        return count;
    }

    @Override
    public List<Diary> queryDiary(Diary diary) {
        List<Diary> diaries = diaryMapper.queryDiary(diary);
        return diaries;
    }



}
