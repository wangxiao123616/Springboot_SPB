package com.soft.spb.controller;


import com.soft.spb.core.annotation.ResponseResult;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.service.impl.CollectbarServiceImpl;
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
@RequestMapping("/collectbar")
public class CollectbarController {

    @Autowired
    CollectbarServiceImpl collectbarServiceImpl;

    @PostMapping("/addCollectBar")
    public Integer addCollectBar(@RequestBody Collectbar collectbar){
        int count = collectbarServiceImpl.addCollectBar(collectbar);
        return count;
    }

    @PostMapping("/deleteCollectBar")
    public Integer deleteCollectBar(@RequestBody Collectbar collectbar){
        int count = collectbarServiceImpl.deleteCollectBar(collectbar);
        return count;

    }

    @PostMapping("/queryCollectBarFullList")
    public List<Collectbar> queryCollectBarFullList(@RequestBody Collectbar collectbar){

        List<Collectbar> collectbars = collectbarServiceImpl.queryCollectBarFullList(collectbar.getUserAccount());
        return collectbars;
    }

    @PostMapping("/queryCollectBarList")
    public List<String> queryCollectBarList(@RequestBody Collectbar collectbar) {

        List<String> collectbars = collectbarServiceImpl.queryCollectBarList(collectbar);

        return collectbars;
    }
}
