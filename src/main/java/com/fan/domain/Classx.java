package com.fan.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("classx")
public class Classx {
    @TableField("id")
    private Integer classxId;

    private String classxName;

    private Integer classxStunum;

    private String classxAddr;

    @TableField(exist = false)
    private List<Student> students;//此属性没有对应的字段封装到里面，会被设置为null

}