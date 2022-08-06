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
import java.util.Map;


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
        System.out.println(video);
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


    @GetMapping("/queryNoVideoSearchBarListForDate")
    public List<PostbarlistVo> queryNoVideoSearchBarListForDate(@RequestParam("search") String search) {
        return postbarlistService.queryNoVideoSearchBarListForDate(search);
    }

    @GetMapping("/queryVideoSearchBarListForDate")
    public List<PostbarlistVo> queryVideoSearchBarListForDate(@RequestParam("search") String search) {
        return postbarlistService.queryVideoSearchBarListForDate(search);
    }

    @PostMapping("/queryNoVideoTopicBarListForDate")
    public List<PostbarlistVo> queryNoVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<PostbarlistVo> topiclist = postbarlistService.queryNoVideoTopicBarListForDate(postbarListDto.getId(), postbarListDto.getPbTopic());
        return topiclist;
    }

    @PostMapping("/queryNoVideoTopicBarListForThumbNum")
    public List<PostbarlistVo> queryNoVideoTopicBarListForThumbNum(@RequestBody PostbarListDto postbarListDto) {
        List<PostbarlistVo> postbarlists = postbarlistService.queryNoVideoTopicBarListForThumbNum(postbarListDto.getPbThumbNum(), postbarListDto.getPbTopic());
        return postbarlists;
    }

    @PostMapping("/queryNoVideoUserBarListForDate")
    public List<PostbarlistVo> queryNoVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<PostbarlistVo> topicBarListForDate = postbarlistService.queryNoVideoUserBarListForDate(postbarListDto.getId(), postbarListDto.getUserAccount());
        return topicBarListForDate;

    }

    @GetMapping("/queryUserBarLikeCount")
    public Integer queryUserBarLikeCount(@RequestParam("userAccount") String userAccount) {
        Integer thumbNum = postbarlistService.postbarlist(userAccount);
        return thumbNum;
    }

    @GetMapping("/queryVideoBarListForDate")
    public List<PostbarlistVo> queryVideoBarListForDate(@RequestParam("id") Long id) {
        List<PostbarlistVo> postbarlists = postbarlistService.queryVideoBarListForDate(id);
        return postbarlists;
    }

    @PostMapping("/queryVideoTopicBarListForDate")
    public List<PostbarlistVo> queryVideoTopicBarListForDate(@RequestBody PostbarListDto postbarListDto) {
        List<PostbarlistVo> postbarlists = postbarlistService.queryVideoTopicBarListForDate(postbarListDto.getId(), postbarListDto.getPbTopic());
        return postbarlists;

    }
    @PostMapping("/queryVideoUserBarListForDate")
    public List<PostbarlistVo> queryVideoUserBarListForDate(@RequestBody PostbarListDto postbarListDto){
        List<PostbarlistVo> postbarlists = postbarlistService.queryVideoUserBarListForDate(postbarListDto.getId(), postbarListDto.getUserAccount());
        return postbarlists;
    }

    @GetMapping("querySearch")
    public Map<String,Object> querySearch(@RequestParam("search")String search){
        return postbarlistService.querySearch(search);
    }
}



