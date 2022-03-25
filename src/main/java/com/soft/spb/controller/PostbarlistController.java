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
    public ResponseBody addBar(@RequestBody Postbarlist postbarlist) {
        int i = postbarlistServiceImpl.addBar(postbarlist);

        return ResponseBody.builder()
                .code(200)
                .msg("受影响的数据位为")
                .data(i)
                .build();
    }


    @PostMapping("/deleteBar/{pbId}")
    public com.soft.spb.util.ResponseBody deleteBar(@PathVariable String pbId) {
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
                    .msg("查询detailForPbid")
                    .data(detatilForPbid.get(0))
                    .build();
        }
    }

    @PostMapping("/queryNoVideoBarListForDate/{date}")
    public ResponseBody queryNoVideoBarListForDate(@PathVariable String date) {
        List<Postbarlist> BarListForDate = postbarlistServiceImpl.queryNoVideoBarListForDate(date);
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(BarListForDate)
                .build();
    }


    @PostMapping("/queryNoVideoFollowBarListForDate")
    public ResponseBody queryNoVideoFollowBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryNoVideoFollowBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(postbarlists)
                .build();
    }


    @PostMapping("/queryNoVideoSearchBarListForDate")

    public ResponseBody queryNoVideoSearchBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> SearchBarList = postbarlistServiceImpl.queryNoVideoSearchBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(SearchBarList)
                .build();

    }

    @PostMapping("/queryNoVideoTopicBarListForDate")
    public ResponseBody queryNoVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> topiclist = postbarlistServiceImpl.queryNoVideoTopicBarListForDate(postbarListDto.getPbDate(), postbarListDto.getPbTopic());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(topiclist)
                .build();
    }

    @PostMapping("/queryNoVideoTopicBarListForThumbNum")
    public ResponseBody queryNoVideoTopicBarListForThumbNum(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryNoVideoTopicBarListForThumbNum(postbarListDto.getPbThumbNum(), postbarListDto.getPbTopic());
        return ResponseBody.builder()
                .code(200)
                .msg("")
                .data(postbarlists)
                .build();
    }
    @PostMapping("/queryNoVideoUserBarListForDate")
    public ResponseBody queryNoVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto){

        List<Postbarlist> topicBarListForDate = postbarlistServiceImpl.queryNoVideoUserBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return ResponseBody
                .builder()
                .code(200)
                .msg("")
                .data(topicBarListForDate)
                .build();

    }
    @PostMapping("/queryUserBarCount")
    public ResponseBody queryUserBarCount(@RequestBody UserDto userDto){
        List<Integer> userBarCount = postbarlistServiceImpl.queryUserBarCount(userDto.getUserAccount());

        int size = userBarCount.size();
        return ResponseBody
                .builder()
                .code(200)
                .msg("")
                .data(size)
                .build();

    }

    @PostMapping("/queryUserBarLikeCount")
    public ResponseBody queryUserBarLikeCount(@RequestBody Postbarlist postbarlist) {
        Integer thumbNum = postbarlistServiceImpl.postbarlist(postbarlist.getUserAccount());

        return ResponseBody
                .builder()
                .code(200)
                .msg("")
                .data(thumbNum)
                .build();
    }

    @PostMapping("/queryVideoBarListForDate")
    public ResponseBody queryVideoBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistServiceImpl.queryVideoBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return ResponseBody
                .builder()
                .code(200)
                .msg("")
                .data(postbarlists)
                .build();
    }
}



