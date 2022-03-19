package com.soft.spb.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class AppVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("versionCode")
    private Integer versionCode;

    @TableField("versionName")
    private String versionName;

    private String detailed;


}
