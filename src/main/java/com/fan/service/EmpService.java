package com.fan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.domain.Emp;
import com.fan.domain.EmpExample;
import com.fan.mapper.EmpMapper;

import javax.annotation.Resource;
import java.util.List;

public interface EmpService extends IService<Emp> {

    IPage<Emp> selectByEmp(Page<Emp> page, Emp emp);
}
