package com.soft.spb.pojo.entity;

import java.time.LocalDate;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id")
    private Integer classId;

    private String className;

    private String classRoom;

    private String classTeacher;

    private LocalDate classDate;

    private String classNum;

    private String classTimeStart;

    private String classTimeOver;


}
