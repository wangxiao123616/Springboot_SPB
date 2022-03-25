package com.soft.spb.controller;


import com.soft.spb.core.annotation.ResponseResult;
import com.soft.spb.pojo.entity.Likepb;
import com.soft.spb.service.impl.LikepbServiceImpl;
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
@ResponseResult
@RestController
@RequestMapping("/likepb")
public class LikepbController {
    @Autowired
    LikepbServiceImpl likepbServiceImpl;

    @PostMapping("/addLike")
    public Integer addLike(@RequestBody Likepb likepb){
        int count = likepbServiceImpl.addLike(likepb);
        return count;

    }

    @PostMapping("/deleteLike")
    public Integer deleteLike(@RequestBody Likepb likepb){
        int count = likepbServiceImpl.deleteLike(likepb);
        return count;
    }

    @PostMapping("/queryLike")
    public List<String> queryLike(@RequestBody Likepb likepb){
        List<String> queryLike = likepbServiceImpl.queryLike(likepb);
        return queryLike;
    }


}
