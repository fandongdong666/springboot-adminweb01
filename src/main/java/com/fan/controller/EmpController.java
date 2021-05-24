package com.fan.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.domain.Emp;
import com.fan.service.EmpService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class EmpController {
    
    @Resource
    private EmpService empService;

    /*模糊查询,+增加分页*/
    @PostMapping("/likeSearch")
    public String selectByEmp(
            @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
            @RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize,
            Emp emp, Model model){

        System.out.println("form表单参数："+emp);
        if(emp.getGender().equals("男")){
            emp.setGender("1");
        }
        if(emp.getGender().equals("女")){
            emp.setGender("0");
        }

        //组建page对象
        Page<Emp> page = new Page<>(pageNum, pageSize);
        //组建queryWrapper
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        Integer id = emp.getId();
        if (StringUtils.isNotBlank(id+"") && id!=null){
            queryWrapper.eq("id",emp.getId());
        }
        if(StringUtils.isNotBlank(emp.getLastName())){
            queryWrapper.like("last_name",emp.getLastName());
        }
        if(StringUtils.isNotBlank(emp.getEmail())){
            queryWrapper.like("email",emp.getEmail());
        }
        if(StringUtils.isNotBlank(emp.getGender())){
            if(emp.getGender().equals("男")){
                emp.setGender("1");
            }
            if(emp.getGender().equals("女")){
                emp.setGender("0");
            }
            queryWrapper.eq("gender",emp.getGender());
        }


        IPage<Emp> empIPage = empService.selectByEmp(page, emp);

        List<Emp> emps = empIPage.getRecords();
        System.out.println("员工数量:"+emps.size());
        System.out.println(emps);
        model.addAttribute("page",empIPage);

        return "table/dynamic_table2";
    }

}
