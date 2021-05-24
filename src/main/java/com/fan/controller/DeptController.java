package com.fan.controller;

import com.fan.domain.Dept;
import com.fan.domain.Emp;
import com.fan.mapper.DeptMapper;
import com.fan.service.DeptService;
import com.fan.service.EmpService;
import com.fan.service.TableService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptController {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private DeptService deptService;
    @Resource
    private TableService tableService;
    @GetMapping("/dynamic_table3")
    public String dynamic_table3(Model model,
                                 @RequestParam(required = true,defaultValue = "1",value ="pageNum" )Integer pageNum,
                                 @RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize
                                 ){
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        Integer deptId = 1;//默认查第一个部门
        PageInfo<Emp> pageInfo = tableService.getAllEmpByPageInfo(pageNum, pageSize);

/*        List<Dept> depts = pageInfo.getList();
        for (Dept dept : depts) {
            List<Emp> emps = dept.getEmps();
            System.out.println("当前部门下的员工：——————————————————————————————");
            for (Emp emp : emps) {
                System.out.println(emp);
            }
        }*/
        model.addAttribute("pageInfo",pageInfo);
        return "table/dynamic_table3";
    }

    @PostMapping("/dynamic_table3")
    public String likeSearchDept(@RequestParam(required = false,defaultValue = "测试部",value = "deptName") String deptName, Model model,
                                 @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
                                 @RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize
                                 ){
        System.out.println("前端参数部门参数："+deptName);
        if(deptName==null){
            System.out.println("部门参数是null");
        }
        PageInfo<Emp> pageInfo = deptService.selectByDeptName(deptName, pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);

        System.out.println(pageInfo.getList());
        System.out.println("部门人数;"+pageInfo.getList().size());
        return "table/dynamic_table3";
    }
}
