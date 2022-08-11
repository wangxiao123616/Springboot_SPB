package com.soft.spb.controller;


import com.soft.spb.pojo.dto.PostbarListDto;
import com.soft.spb.pojo.entity.Collectbar;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.service.CollectbarService;
import com.soft.spb.service.impl.CollectbarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/collectbar")
public class CollectbarController {

    @Autowired
    CollectbarService collectbarService;

    @PostMapping("/addCollectBar")
    public boolean addCollectBar(@RequestBody Collectbar collectbar) {
        return collectbarService.addCollectBar(collectbar);
    }

    @PostMapping("/deleteCollectBar")
    public boolean deleteCollectBar(@RequestBody Collectbar collectbar) {
        return collectbarService.deleteCollectBar(collectbar);

    }

    @GetMapping("/queryCollectBarFullList")
    public List<PostbarlistVo> queryCollectBarFullList(@RequestParam("id") Long id, @RequestParam("userAccount") String userAccount) {
        return collectbarService.queryCollectBarFullList(id, userAccount);
    }
//
//    @PostMapping("/queryCollectBarList")
//    public List<String> queryCollectBarList(@RequestBody Collectbar collectbar) {
//
//        List<String> collectbars = collectbarService.queryCollectBarList(collectbar);
//
//        return collectbars;
//    }
}
