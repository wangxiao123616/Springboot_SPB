package com.soft.spb.controller;


import com.soft.spb.pojo.dto.PostbarListDto;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.Postbarlist;
import com.soft.spb.pojo.vo.PostbarlistVo;
import com.soft.spb.service.PostbarlistService;
import com.soft.spb.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    PostbarlistService postbarlistService;

    @PostMapping("/addBar")
    public Integer addBar(Postbarlist postbarlist, @Nullable @RequestParam("image") MultipartFile[] image,@Nullable @RequestParam("voice")MultipartFile[] voice) {
        int i = 0;
        try {
            i = postbarlistService.addBar(postbarlist,image,voice);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i;
    }

    @PostMapping("/addBarVideo")
    public Integer addBarVideo(Postbarlist postbarlist,@Nullable @RequestParam("video")MultipartFile[] video){
        Integer count = postbarlistService.addBarVideo(postbarlist, video);
        return count;

    }


    @PostMapping("/deleteBar/{pbId}")
    public ResponseBody deleteBar(@PathVariable String pbId) {
        Boolean post = postbarlistService.deleteBar(pbId);
        return ResponseBody.builder()
                .code(200)
                .msg("删除成功")
                .data("")
                .build();


    }

    @PostMapping("/queryBarDetatilForPbid")

    public ResponseBody queryBarDetatilForPbid(@RequestBody Postbarlist postbarlist) {
        List<Postbarlist> detatilForPbid = postbarlistService.queryBarDetatilForPbid(postbarlist);
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

    @GetMapping("/queryNoVideoBarListForDate")
    public List<PostbarlistVo> queryNoVideoBarListForDate(@RequestParam("id") Long id) {
        List<PostbarlistVo> BarListForDate = postbarlistService.queryNoVideoBarListForDate(id);
        return BarListForDate;
    }


    @GetMapping("/queryNoVideoFollowBarListForDate")
    public List<PostbarlistVo> queryNoVideoFollowBarListForDate(@RequestParam("id") Long id, @RequestParam("userAccount") String userAccount) {
        List<PostbarlistVo> postbarlists = postbarlistService.queryNoVideoFollowBarListForDate(id, userAccount);
        return postbarlists;
    }


    @PostMapping("/queryNoVideoSearchBarListForDate")

    public List<Postbarlist> queryNoVideoSearchBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<Postbarlist> SearchBarList = postbarlistService.queryNoVideoSearchBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return SearchBarList;

    }

    @PostMapping("/queryNoVideoTopicBarListForDate")
    public List<PostbarlistVo> queryNoVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<PostbarlistVo> topiclist = postbarlistService.queryNoVideoTopicBarListForDate(postbarListDto.getPbDate(), postbarListDto.getPbTopic());
        return topiclist;
    }

    @PostMapping("/queryNoVideoTopicBarListForThumbNum")
    public List<Postbarlist> queryNoVideoTopicBarListForThumbNum(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistService.queryNoVideoTopicBarListForThumbNum(postbarListDto.getPbThumbNum(), postbarListDto.getPbTopic());
        return postbarlists;
    }

    @PostMapping("/queryNoVideoUserBarListForDate")
    public List<PostbarlistVo> queryNoVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto) {

        List<PostbarlistVo> topicBarListForDate = postbarlistService.queryNoVideoUserBarListForDate(postbarListDto.getId(), postbarListDto.getUserAccount());
        return topicBarListForDate;

    }

    @PostMapping("/queryUserBarCount")
    public Integer queryUserBarCount(@RequestBody UserDto userDto) {
        List<Integer> userBarCount = postbarlistService.queryUserBarCount(userDto.getUserAccount());

        int size = userBarCount.size();
        return size;

    }

    @PostMapping("/queryUserBarLikeCount")
    public Integer queryUserBarLikeCount(@RequestBody Postbarlist postbarlist) {
        Integer thumbNum = postbarlistService.postbarlist(postbarlist.getUserAccount());

        return thumbNum;
    }

    @PostMapping("/queryVideoBarListForDate")
    public List<Postbarlist> queryVideoBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistService.queryVideoBarListForDate(postbarListDto.getPbTopic(), postbarListDto.getPbArticle());
        return postbarlists;
    }

    @PostMapping("/queryVideoTopicBarListForDate")
    public List<Postbarlist> queryVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<Postbarlist> postbarlists = postbarlistService.queryVideoTopicBarListForDate(postbarListDto.getPbDate(), postbarListDto.getPbTopic());
        return postbarlists;

    }
    @PostMapping("/queryVideoUserBarListForDate")
    public List<Postbarlist> queryVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto){
        List<Postbarlist> postbarlists = postbarlistService.queryVideoUserBarListForDate(postbarListDto.getPbDate(), postbarListDto.getUserAccount());
        return postbarlists;

    }

}



