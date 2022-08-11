package com.soft.spb.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nmy
 * @title: RandomUserVo
 * @date 2022-04-09 19:01
 */
@Data
public class RandomUserVo implements Serializable {

    private Long id;

    private String userAccount;

    private String userHeadImg;

    private String userName;

    private Integer followNum;
}
