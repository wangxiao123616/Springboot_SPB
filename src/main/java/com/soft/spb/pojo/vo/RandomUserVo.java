package com.soft.spb.pojo.vo;

import lombok.Data;

/**
 * @author nmy
 * @title: RandomUserVo
 * @date 2022-04-09 19:01
 */
@Data
public class RandomUserVo {

    private Long id;

    private String userAccount;

    private String userName;

    private Integer followNum;
}
