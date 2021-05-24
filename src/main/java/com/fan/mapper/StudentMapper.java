package com.fan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.domain.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    IPage<Student> selectPageVo(Page<?> page, Integer state);
    //分页测试：
    List<Student> queryStudentInfo();
//查询所有

    Student selectStuAndClassById(Integer id);
    List<Student> selectStuAndClassByStu(Student student);
    //根据学生外键查找
    List<Student> selectByOutKey(Integer classc_id);
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}