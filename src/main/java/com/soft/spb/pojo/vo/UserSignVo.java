package com.soft.spb.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSignVo implements Serializable {

    private String userAccount;

    private String signStarBadge;

    private String signTaskBadge;

    private String signLikeBadge;

    private Integer signCtBadge;

}
