package com.fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.domain.Emp;
import com.fan.domain.EmpExample;
import com.fan.entity.GoodsUser;
import com.fan.mapper.EmpMapper;
import com.fan.mapper.GoodsUserMapper;
import com.fan.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public IPage<Emp> selectByEmp(Page<Emp> page, Emp emp) {
        //mapper接口和mapper.xml底层都是查询一个完整的list,分页逻辑是设置在service层的

        IPage<Emp> empIPage = empMapper.selectByEmp(page, emp);

        return empIPage;
    }
}
