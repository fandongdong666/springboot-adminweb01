package com.fan.service;

import com.fan.domain.Emp;
import com.fan.domain.EmpExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TableService {
    public List<Emp> selectAllEmpAndDept();

    //带分页的查找
    PageInfo<Emp> getAllEmpByPageInfo(Integer pageNum,Integer pageSize);

}
