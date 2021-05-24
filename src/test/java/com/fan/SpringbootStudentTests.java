package com.fan;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.domain.Classx;
import com.fan.domain.LoginUser;
import com.fan.domain.Student;
import com.fan.mapper.ClassxMapper;
import com.fan.mapper.LoginUserMapper;
import com.fan.mapper.StudentMapper;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootStudentTests {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private LoginUserMapper loginUserMapper;
    @Resource
    private ClassxMapper classxMapper;

    @Test
    void contextLoads() {
        Student student1 = new Student();
        student1.setName("r");
        List<Student> student = studentMapper.selectStuAndClassByStu(student1);
        for (Student student2 : student) {

            System.out.println(student2);
        }
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

    @Test//班级测试
    void contextLoads2() {
/*        List<LoginUser> loginUsers = loginUserMapper.selectList(null);
        Assert.assertEquals(2,loginUsers.size());
        loginUsers.forEach(System.out::println);*/

/*        List<Student> students = studentMapper.selectList(null);
        Assert.assertEquals(9,students.size());
        students.forEach(System.out::println);*/


        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name","r")
                .orderByDesc("score");

        Page<Student> page = new Page<>(1,5);

        Page pageParam = studentMapper.selectPage(page, queryWrapper);

        List<Student> records = pageParam.getRecords();
        records.forEach(System.out::println);

        System.out.println(pageParam.getPages());//总页数
        System.out.println(pageParam.getTotal());//总记录数
        System.out.println(pageParam.getCurrent());//当前页码
        System.out.println(pageParam.getSize());//每页记录数
        System.out.println(pageParam.hasNext());//是否有下一页
        System.out.println(pageParam.hasPrevious());//是否有上一页


    }



}
