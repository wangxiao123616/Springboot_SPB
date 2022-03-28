package com.soft.spb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.spb.pojo.entity.Diary;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface DiaryService extends IService<Diary> {

    int addDiary(Diary diary, MultipartFile[] file);
    int deleteDiary(Diary diary);

    List<Diary> queryDiary(Diary diary);


}
