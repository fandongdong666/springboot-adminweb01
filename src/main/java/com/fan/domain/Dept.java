package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptId;

    private String deptName;
    //每一个部门下有很多员工
    private List<Emp> emps;
}