package com.fan.service.impl;

import com.fan.domain.Dept;
import com.fan.domain.Emp;
import com.fan.mapper.DeptMapper;
import com.fan.mapper.EmpMapper;
import com.fan.service.DeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private EmpMapper empMapper;
    @Override
    public PageInfo<Dept> selectAllDeptByPageInfo(Integer pageNum, Integer pageSize) {
        //利用分页插件进行设置
        Page<Dept> page = PageHelper.startPage(pageNum, pageSize);


        List<Dept> depts = deptMapper.selectAllDept();
        PageInfo<Dept> deptPageInfo = new PageInfo<>(depts, 5);
        return deptPageInfo;
    }

    @Override
    public PageInfo<Emp> selectAllDeptByPageDeptId(Integer pageNum, Integer pageSize, Integer deptId) {
        //利用分页插件进行设置
        Page<Dept> page = PageHelper.startPage(pageNum, pageSize);
        List<Emp> emps = deptMapper.selectByPrimaryKey(deptId).getEmps();
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps, 5);
        return pageInfo;
    }

    @Override
    public PageInfo selectByDeptName(String deptName,Integer pageNum,Integer pageSize) {

        Dept dept1 = new Dept();
        //根据部门名称查出部门信息，然后部门id作为下一次查找条件
        Dept dept = deptMapper.selectByDeptName(deptName);
        Integer deptId = dept.getDeptId();
        System.out.println("后台根据部门名称查出来的部门id:"+deptId);
        List<Emp> empspre = empMapper.selectByDeptId(deptId);
        System.out.println("数据库根据部门d_id查出来的emp--------------"+empspre.size());

        Page<Emp> page = PageHelper.startPage(pageNum, pageSize);
        List<Emp> result = page.getResult();//分页中的数据
        System.out.println("Page中的数据："+result);
        System.out.println("========page对象：========"+page);
        List<Emp> emps = empMapper.selectByDeptId(deptId);
        System.out.println("数据库根据部门d_id查出来的emp"+emps.size());
        for (Emp emp : emps) {
            //设置每个员工的部门名字
            dept1.setDeptName(dept.getDeptName());
          emp.setDept(dept1);
        }
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps,10);
        System.out.println("分页后的数据："+pageInfo.getList().size());
        return pageInfo;
    }
}
