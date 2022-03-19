package com.soft.spb.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userAccount;

    private String userName;

    private LocalDate userBirth;

    private String userHome;

    private String userFavorite;

    private String userProfile;

    private String userHeadImage;

    private String userBgImage;

    private String userBadge;

    private Integer userLongday;

    private String userPrivacy;

    private String userIp;

    private String userToken;


}