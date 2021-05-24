package com.fan.service.impl;

import com.fan.domain.Emp;
import com.fan.domain.EmpExample;
import com.fan.domain.Student;
import com.fan.mapper.EmpMapper;
import com.fan.service.TableService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TableServiceImpl implements TableService {
    @Resource
    private EmpMapper empMapper;

    @Override//不带分页的查找
    public List<Emp> selectAllEmpAndDept() {
        List<Emp> emps = empMapper.selectAllEmpAndDept();
        return emps;
    }

    @Override//带分页的查找，将普通的查找进行分页分装
    public PageInfo<Emp> getAllEmpByPageInfo(Integer pageNum,Integer pageSize) {
        //分页的启动页的分页设置,分页一定要至少传递这两个参数
        Page<Student> page = PageHelper.startPage(pageNum, pageSize);
        //紧跟分页设置的后的第一个查询会被分页查询
        List<Emp> emps = empMapper.selectAllEmpAndDept();

        System.out.println("page对象：================="+page);
        System.out.println("page对象的结果：****************"+page.getResult());
        System.out.println("page对象的结果：****************");
        //navigatepage（导航页）：默认显示5个连续页,页码导航连续显示的页数5
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        //Page<Emp> page = new Page<Emp>(emps, 5);
        return empPageInfo;
    }
}
