package com.soft.spb.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nmy
 * @title: FollowListVo
 * @date 2022-04-14 22:09
 */
@Data
public class FollowListVo implements Serializable {

    private Long id;
    private String userAccount;
    private String userName;
    private String sex;
    private String userProfile;
    private String userBadge;
    private String userHeadImg;
}