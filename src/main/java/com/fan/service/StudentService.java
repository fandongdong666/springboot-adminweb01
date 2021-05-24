package com.fan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.domain.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> selectStuAndClassByStu(Student student);
    //查询所有
    List<Student> queryStudentInfo();

    //分页需要的方法
    List<Student> findAllStudentByPageF(int pageNum,int pageSize);
    //PageInfo是官方包下的com.github.pagehelper
    PageInfo<Student> findAllStudentByPageS(int pageNum, int pageSize);
}
