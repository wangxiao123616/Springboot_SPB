package com.soft.spb.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttentiontopicDto implements Serializable {
    private String search;
    private String userAccount;
    private Long id;
}
