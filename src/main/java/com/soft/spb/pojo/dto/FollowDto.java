package com.soft.spb.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nmy
 * @title: FollowDto
 * @date 2022-04-15 18:12
 */
@Data
public class FollowDto implements Serializable {

    private Long id;

    private String userAccount;

}
