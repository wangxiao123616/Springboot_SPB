package com.soft.spb.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PostbarlistVo {

    private Long id;

    private String userName;

    private String userBadge;

    private String userHeadImg;

    private String pbOneId;

    private String userAccount;

    private LocalDateTime pbDate;

    private String pbArticle;

    private String pbImageUrl;

    private String pbVoice;

    private String pbVideo;

    private String pbTopic;

    private String pbLocation;

    private Integer pbThumbNum;

    private Integer pbCommentNum;
}
