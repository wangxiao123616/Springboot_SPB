package com.soft.spb.controller;


import com.soft.spb.pojo.entity.Likepb;
import com.soft.spb.service.LikepbService;
import com.soft.spb.service.impl.LikepbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/likepb")
public class LikepbController {
    @Autowired
    LikepbService likepbService;

    @PostMapping("/addLike")
    public Boolean addLike(@RequestBody Likepb likepb) {
        return likepbService.addLike(likepb);

    }

    @PostMapping("/deleteLike")
    public Boolean deleteLike(@RequestBody Likepb likepb) {
        return likepbService.deleteLike(likepb);
    }

//    @PostMapping("/queryLike")
//    public List<String> queryLike(@RequestBody Likepb likepb) {
//        List<String> queryLike = likepbService.queryLike(likepb);
//        return queryLike;
//    }


}
