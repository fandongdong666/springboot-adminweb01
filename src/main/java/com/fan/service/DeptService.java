package com.fan.service;

import com.fan.domain.Dept;
import com.fan.domain.Emp;
import com.github.pagehelper.PageInfo;

public interface DeptService {
    //根据分页查找
    PageInfo<Dept> selectAllDeptByPageInfo(Integer pageNum,Integer pageSize);
    PageInfo<Emp> selectAllDeptByPageDeptId(Integer pageNum, Integer pageSize, Integer deptId);
    PageInfo<Emp> selectByDeptName(String deptName,Integer pageNum,Integer pageSize);

}
