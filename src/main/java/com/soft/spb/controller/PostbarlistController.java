package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.service.impl.PostbarlistServiceImpl;
import com.soft.spb.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/postbarlist")
public class PostbarlistController {
    @Autowired
    PostbarlistServiceImpl postbarlistServiceImpl;

    @PostMapping("/deleteBar/{pbId}")
    public com.soft.spb.util.ResponseBody deleteBar(@PathVariable String  pbId) {
        Boolean post = postbarlistServiceImpl.deleteBar(pbId);
        return  ResponseBody.builder()
                .code(200)
                .msg("删除成功")
                .data("")
                .build();


    }

    @PostMapping("/queryBarDetatilForPbid")

    public ResponseBody queryBarDetatilForPbid(@RequestBody Postbarlist postbarlist) {
        List<Postbarlist> detatilForPbid = postbarlistServiceImpl.queryBarDetatilForPbid(postbarlist);
                       if(detatilForPbid.size() == 0){
                           return ResponseBody.builder()
                                   .code(200)
                                   .msg("")
                                   .build();
                       }else{
                           return ResponseBody.builder()
                                   .code(200)
                                   .msg("查询detailForPbid")
                                   .data(detatilForPbid.get(0))
                                   .build();
                       }


    }

    @PostMapping("/queryNoVideoBarListForDate/{date}")
    public ResponseBody queryNoVideoBarListForDate(@PathVariable String  date) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryNoVideoBarListForDate(date);
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(postbarlists)
                .build();
    }



}
