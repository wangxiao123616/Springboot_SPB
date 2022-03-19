package com.soft.spb.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Postbarlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String pbOneId;

    private String userAccount;

    private LocalDateTime pbDate;

    private String pbArticle;

    private String pbImageUrl;

    private String pbVoice;

    private String pbVideo;

    private String pbTopic;

    private String pbLocation;

    private Integer pbThumbNum;

    private Integer pbCommentNum;


}
