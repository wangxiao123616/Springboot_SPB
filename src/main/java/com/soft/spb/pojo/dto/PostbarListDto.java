package com.soft.spb.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostbarListDto implements Serializable {

    private Long id;
    private String pbTopic;
    private String pbArticle;
    private String pbDate;
    private String userAccount;
    private Integer pbThumbNum;

}
