package com.fan.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;//学号

    private String name;

    private Integer age;

    private Integer score;

    private String addr;

    private String phone;

    private String fatherName;

    private String motherName;

    private String fatherJob;

    private String motherJob;

    @TableField( value = "classc_id",exist = false)
    private Classx classx;

 }