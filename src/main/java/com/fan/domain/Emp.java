package com.fan.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("emp")
public class Emp {
    //IdType.AUTO主键自增
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String lastName;

    private String email;

    private String gender;//性别是String类型

    //private Integer dId;其他封装会不会缺少这个出现问题
    //每个员工有一个部门
    private Dept dept;

}