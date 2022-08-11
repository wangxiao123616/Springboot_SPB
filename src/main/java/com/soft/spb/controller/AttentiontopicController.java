package com.soft.spb.controller;


import com.soft.spb.pojo.dto.AttentiontopicDto;
import com.soft.spb.pojo.entity.Attentiontopic;
import com.soft.spb.pojo.vo.AttentiontopicVo;
import com.soft.spb.service.AttentiontopicService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/attentiontopic")
public class AttentiontopicController {

    @Autowired
    AttentiontopicService attentiontopicService;

    @PostMapping("/addAttentionTopic")
    public Boolean addAttentionTopic(@RequestBody Attentiontopic attentiontopic) {
        return attentiontopicService.addAttentionTopic(attentiontopic);
    }

    @PostMapping("/deleteAttentionTopicById")
    public Boolean deleteAttentionTopicById(@RequestBody Attentiontopic attentiontopic) {
        return attentiontopicService.deleteAttentionTopicById(attentiontopic);
    }

    @GetMapping("/queryAttentionTopic")
    public List<AttentiontopicVo> queryAttentionTopic(AttentiontopicDto attentiontopicDto) {
        return attentiontopicService.queryAttentionTopic(attentiontopicDto);
    }
}
