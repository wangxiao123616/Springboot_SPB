package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Diary;
import com.soft.spb.service.impl.DiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
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
    public Integer addDiary(@RequestParam("file") MultipartFile[] sourceFiles,
                            @RequestParam("userAccount") String userAccount,
                            @RequestParam("diaWeather") Integer diaWeather,
                            @RequestParam("diaMessage") String diaMessage) {

        //, @RequestParam("userAccount") String userAccount,
        //                            @RequestParam("diaDate") LocalDateTime diaDate, @RequestParam("diaWeather") Integer diaWeather,
        //                            @RequestParam("diaMessage") String diaMessage
        // @RequestParam("diaImage")String diaImage

        LocalDateTime now = LocalDateTime.now();



        System.out.println(sourceFiles);
        System.out.println(userAccount);
       System.out.println(now);
       System.out.println(diaWeather);
       System.out.println(diaMessage);
//        int count = diaryServiceImpl.addDiary( sourceFiles);
         return null;

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
