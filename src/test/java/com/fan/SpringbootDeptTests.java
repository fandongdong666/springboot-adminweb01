package com.fan;


import com.fan.domain.Classx;
import com.fan.domain.Emp;
import com.fan.domain.Student;
import com.fan.mapper.ClassxMapper;
import com.fan.mapper.DeptMapper;
import com.fan.mapper.EmpMapper;
import com.fan.mapper.StudentMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootDeptTests {


    @Resource
    private EmpMapper empMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private ClassxMapper classxMapper;

    @Test
    void contextLoads() {
        List<Emp> emps = empMapper.selectByDeptId(1);
        System.out.println("部门人数;"+emps.size());
        System.out.println();
    }

    @Test//班级测试
    void contextLoads1() {
       /* List<Student> students =    studentMapper.selectByOutKey(1);
        for (Student student : students) {
            System.out.println(student);
        }*/
        Classx classx = new Classx();
        classx.setClassxName("一班");
        /*classx.setClassxId(1);*/
        Classx classx1 = classxMapper.selectClassXByClassx(classx);
        System.out.println(classx1);
    }


}
