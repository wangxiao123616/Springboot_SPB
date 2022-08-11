package com.soft.spb.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author nmy
 * @title: UpdatePwdDto
 * @date 2022-08-03 11:26
 */
@Data
public class UpdatePwdDto implements Serializable {

    private String userAccount;
    @TableId("user_password")
    private String userOldPwd;
    private String userPwd;

}
