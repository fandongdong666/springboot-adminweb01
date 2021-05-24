package com.fan;

import com.fan.domain.Dept;
import com.fan.domain.Emp;
import com.fan.mapper.DeptMapper;
import com.fan.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootAdminweb01ApplicationTests {

    @Resource
    private EmpMapper empMapper;
    @Resource
    private DeptMapper deptMapper;

    @Test
    void contextLoads() {
       /* List<Emp> emps = empMapper.selectAllEmpAndDept();
        for (Emp emp : emps) {
            System.out.println(emp);
        }*/

        Dept dept = deptMapper.selectByDeptName("开");
        System.out.println(dept);

        /*List<Emp> emps = empMapper.selectByDeptId(1);
        for (Emp emp : emps) {
            System.out.println(emp);
        }*/

    }
}
