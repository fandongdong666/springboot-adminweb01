package com.fan.mapper;

import com.fan.domain.Dept;
import com.fan.domain.Emp;

import java.util.List;

public interface DeptMapper {

    //根据部门名字查出部门信息
    Dept selectByDeptName(String deptName);

    //查询所有的部门及部门下的员工
    List<Dept> selectAllDept();
    //根据部门编号
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);
    //根据部门编号查出部门信息（这里不包含员工emps属性）
    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}