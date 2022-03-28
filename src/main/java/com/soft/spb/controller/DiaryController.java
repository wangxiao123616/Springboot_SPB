package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Diary;
import com.soft.spb.service.impl.DiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
