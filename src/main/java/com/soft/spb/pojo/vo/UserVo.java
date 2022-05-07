package com.soft.spb.pojo.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserVo {

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
