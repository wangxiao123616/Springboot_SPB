package com.soft.spb.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostbarCommentVo {
    private String pbOneId;

    private String commentArt;

    private LocalDateTime commentDate;

    private String commentUser;

    private String commentTouser;

    private Integer commentId;

    private String userAccount;

    private String userName;

    private String userToname;

    private String commentHeadImg;
}
