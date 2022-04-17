package com.soft.spb.pojo.dto;

import lombok.Data;

@Data
public class PostbarListDto {

    private Long id;
    private String pbTopic;
    private String pbArticle;
    private String pbDate;
    private String userAccount;
    private Integer pbThumbNum;

}
