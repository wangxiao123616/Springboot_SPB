package com.soft.spb.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttentiontopicVo implements Serializable {
    private Integer attid;

    private String topicName;

    private Integer topicBarnum;

    private Integer topicAttentionnum;

    private String topicSlogan;

    private String topicImage;

    private LocalDateTime topicDate;

    private Integer id;

}
