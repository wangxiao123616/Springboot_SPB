package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Diary;
import com.soft.spb.service.impl.DiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryServiceImpl diaryServiceImpl;

    @PostMapping("/addDiary")
    public Integer addDiary(Diary diary,@RequestParam("sourceFiles") MultipartFile[] sourceFiles) {

        int count = diaryServiceImpl.addDiary(diary, sourceFiles);
        return count;

    }

    @PostMapping("/deleteDiary")
    public Integer deleteDiary(@RequestBody Diary diary){
        int count = diaryServiceImpl.deleteDiary(diary);
        return count;
    }

      @PostMapping("/queryDiary")
    public List<Diary> queryDiary(@RequestBody Diary diary){
        List<Diary> diaries = diaryServiceImpl.queryDiary(diary);
        return diaries;
    }




}
