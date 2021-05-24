package com.fan.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.domain.Emp;
import com.fan.domain.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper extends BaseMapper<Emp> {


    List<Emp> selectAllEmpAndDept();

    List<Emp> selectAllEmpAndDeptByEmp(Emp emp);

    List<Emp> selectByDeptId(Integer deptId);

    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    /*自定义的MP分页,page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位*/
    IPage<Emp> selectByEmp(Page<Emp> page, Emp emp);

    Emp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}