package com.fan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.domain.Student;
import com.fan.entity.GoodsUser;
import com.fan.mapper.GoodsUserMapper;
import com.fan.mapper.StudentMapper;
import com.fan.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public List<Student> selectStuAndClassByStu(Student student) {
        return studentMapper.selectStuAndClassByStu(student);
    }

    @Override
    public List<Student> queryStudentInfo() {
        return studentMapper.queryStudentInfo();
    }

    @Override
    public List<Student> findAllStudentByPageF(int pageNum, int pageSize) {
        //PageHelper系统类对象：分页助手
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.queryStudentInfo();
        return students;
    }

    @Override
    public PageInfo<Student> findAllStudentByPageS(int pageNum, int pageSize) {
       /* 在你需要进行分页的 MyBatis 查询方法前调用 PageHelper.startPage 静态方法即可，
        紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页。后面的其他查询不会被分页，除非再次调用PageHelper.startPage*/
        PageHelper.startPage(pageNum,pageSize);//此方法必须在查询方法前
        List<Student> students = studentMapper.queryStudentInfo();
        //用PageInfo对结果进行包装
        //PageInfo也是系统的一个重要类，是com.github.pagehelper.PageInfo;，注意：要将list传进去
        //5是连续显示多少页
        PageInfo<Student> studentPageInfo = new PageInfo<Student>(students,5);
        return studentPageInfo;
    }
}
