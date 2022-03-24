package com.soft.spb.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PostbarlistVo {

    private String userName;

    private String userBadge;


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