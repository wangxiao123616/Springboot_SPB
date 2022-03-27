package com.soft.spb.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.DiaryMapper;
import com.soft.spb.pojo.entity.Diary;
import com.soft.spb.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public int addDiary(Diary diary) {
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
