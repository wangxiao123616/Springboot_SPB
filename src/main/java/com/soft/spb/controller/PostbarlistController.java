package com.soft.spb.controller;


import com.soft.spb.pojo.dto.PostbarListDto;
import com.soft.spb.pojo.dto.UserDto;
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

    @PostMapping("/addBar")
    public Integer addBar(@RequestBody Postbarlist postbarlist) {
        int i = postbarlistServiceImpl.addBar(postbarlist);

        return i;
    }


    @PostMapping("/deleteBar/{pbId}")
    public ResponseBody deleteBar(@PathVariable String pbId) {
        Boolean post = postbarlistServiceImpl.deleteBar(pbId);
        return ResponseBody.builder()
                .code(200)
                .msg("删除成功")
                .data("")
                .build();


    }

    @PostMapping("/queryBarDetatilForPbid")

    public ResponseBody queryBarDetatilForPbid(@RequestBody Postbarlist postbarlist) {
        List<Postbarlist> detatilForPbid = postbarlistServiceImpl.queryBarDetatilForPbid(postbarlist);
        if (detatilForPbid.size() == 0) {
            return ResponseBody.builder()
                    .code(200)
                    .msg("")
                    .build();
        } else {
            return ResponseBody.builder()
                    .code(200)
                    .msg("成功")
                    .data(detatilForPbid.get(0))
                    .build();
        }
    }

    @PostMapping("/queryNoVideoBarListForDate/{date}")
    public List<Postbarlist> queryNoVideoBarListForDate(@PathVariable String date) {
        List<Postbarlist> BarListForDate = postbarlistServiceImpl.queryNoVideoBarListForDate(date);
        return BarListForDate;
    }


    @PostMapping("/queryNoVideoFollowBarListForDate")
    public List<Postbarlist> queryNoVideoFollowBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryNoVideoFollowBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return postbarlists;
    }


    @PostMapping("/queryNoVideoSearchBarListForDate")

    public List<Postbarlist> queryNoVideoSearchBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> SearchBarList = postbarlistServiceImpl.queryNoVideoSearchBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return SearchBarList;

    }

    @PostMapping("/queryNoVideoTopicBarListForDate")
    public List<Postbarlist> queryNoVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> topiclist = postbarlistServiceImpl.queryNoVideoTopicBarListForDate(postbarListDto.getPbDate(), postbarListDto.getPbTopic());
        return topiclist;
    }

    @PostMapping("/queryNoVideoTopicBarListForThumbNum")
    public List<Postbarlist> queryNoVideoTopicBarListForThumbNum(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryNoVideoTopicBarListForThumbNum(postbarListDto.getPbThumbNum(), postbarListDto.getPbTopic());
        return postbarlists;
    }

    @PostMapping("/queryNoVideoUserBarListForDate")
    public List<Postbarlist> queryNoVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> topicBarListForDate = postbarlistServiceImpl.queryNoVideoUserBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return topicBarListForDate;

    }

    @PostMapping("/queryUserBarCount")
    public Integer queryUserBarCount(@RequestBody UserDto userDto) {
        List<Integer> userBarCount = postbarlistServiceImpl.queryUserBarCount(userDto.getUserAccount());

        int size = userBarCount.size();
        return size;

    }

    @PostMapping("/queryUserBarLikeCount")
    public Integer queryUserBarLikeCount(@RequestBody Postbarlist postbarlist) {
        Integer thumbNum = postbarlistServiceImpl.postbarlist(postbarlist.getUserAccount());

        return thumbNum;
    }

    @PostMapping("/queryVideoBarListForDate")
    public List<Postbarlist> queryVideoBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryVideoBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return postbarlists;
    }

    @PostMapping("/queryVideoTopicBarListForDate")
    public List<Postbarlist> queryVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryVideoTopicBarListForDate(postbarListDto.getPbDate(), postbarListDto.getPbTopic());
        return postbarlists;

    }
    @PostMapping("/queryVideoUserBarListForDate")
    public List<Postbarlist> queryVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto){
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryVideoUserBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return postbarlists;

    }

}



