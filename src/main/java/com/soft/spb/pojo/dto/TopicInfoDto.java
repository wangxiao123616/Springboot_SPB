package com.soft.spb.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nmy
 * @title: TopicInfoDto
 * @date 2022-04-12 14:15
 */
@Data
public class TopicInfoDto implements Serializable {

    private Integer topicId;

    private String topicName;

}
