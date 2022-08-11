package com.soft.spb.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserVo implements Serializable {

    private Integer id;

    private String userAccount;

    private String userName;

    private String userBadge;

    private String stuSex;

    private LocalDate userBirth;

    private String userHome;

    private String userFavorite;

    private String userProfile;

    private String userHeadImage;

    private String userBgImage;

    private Integer userLongday;

    private String userPrivacy;

    private String stuName;

    private Integer stuYear;

    private String stuDepartment;

    private String stuMajor;

    private Integer stuClass;

}
