package com.fan.controller;

import com.fan.domain.Student;
import com.fan.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;
    @GetMapping("/dynamic_table_student")
    public String dynamic_table_student(Student student, Model model){
        List<Student> students = studentService.selectStuAndClassByStu(student);
        model.addAttribute("students",students);
        return "table/dynamic_table_student";
    }

    @PostMapping("/dynamic_table_student")
    public String dynamic_search_student(Student student, Model model){
        List<Student> students = studentService.selectStuAndClassByStu(student);
        model.addAttribute("students",students);

        return "table/dynamic_table_student";
    }

    //分页测试

    @GetMapping("/testPageHelper1")
    public String testPageHelper1(Model model,
                                  @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
                                  @RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize
    ){
        System.out.println("前端请求参数-当前页码："+pageNum);
        if(pageNum ==null ){
            pageNum = 1;
        }
        if(pageSize == null ){
            pageSize = 3;
        }
        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count,分页逻辑放在了service
        PageInfo<Student> pageInfo = studentService.findAllStudentByPageS(pageNum, pageSize);
        //4.使用model/map/modelandview等带回前端
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("分页测试："+pageInfo);
        System.out.println("*******************");
        System.out.println("数据集合:"+pageInfo.getList());
        System.out.println("*******************");
        return "table/dynamic_table_student";
    }

}
