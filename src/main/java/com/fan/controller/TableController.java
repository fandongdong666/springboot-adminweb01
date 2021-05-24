package com.fan.controller;


import com.fan.domain.*;
import com.fan.mapper.DeptMapper;
import com.fan.mapper.LoginUserMapper;
import com.fan.service.TableService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Controller
public class TableController {
    @Resource
    private TableService tableService;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private LoginUserMapper loginUserMapper;

    @GetMapping("/basic_table")
    public String basic_table(Model model){
        List<LoginUser> users = loginUserMapper.getLoginUsers();
        System.out.println(users);
        model.addAttribute("users",users);
        return "table/basic_table";
    }
    //emp动态表格
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //直接将参数设置为null,
        List<Emp> emps = tableService.selectAllEmpAndDept();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
        model.addAttribute("emps",emps);
        return "table/dynamic_table";
    }

    //查询所有emp,二次改造时，将分页参数设置进去
    @GetMapping("/dynamic_table2")
    public String dynamic_table2(Model model,
                                 @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
                                 @RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize
                                 ){

        log.info("前端分页参数：pageNum:{},pageSize:{}",pageNum,pageSize);
        System.out.println("前端的pageSize===="+pageSize);
        //直接将参数设置为null
       /* List<Emp> emps = tableService.selectAllEmpAndDept();
        for (Emp emp : emps) {
                System.out.println(emp);
        }*/
        PageInfo<Emp> pageInfo = tableService.getAllEmpByPageInfo(pageNum, pageSize);
        List<Emp> list = pageInfo.getList();
        System.out.println("下拉框测试list:"+list);
        System.out.println("下拉框测试list个数:"+list.size());
        //model.addAttribute("emps",emps);
        model.addAttribute("pageInfo",pageInfo);
        return "table/dynamic_table2";
    }






    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
