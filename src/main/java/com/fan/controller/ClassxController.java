package com.fan.controller;

import com.fan.domain.Classx;
import com.fan.service.ClassxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
@Slf4j
@Controller
public class ClassxController {
    @Resource
    private ClassxService classxService;
    @PostMapping("/dynamic_table_class")
    public String dynamic_table_class(Classx classx, Model model){
        log.info("参数：{}",classx);
        if(classx.getClassxName()==""){
            classx.setClassxName(null);
        }
        Classx classx1 = classxService.selectClassXByClassx(classx);
        model.addAttribute("students",classx1.getStudents());//存入班级中的学生

        return "table/dynamic_table_student";
    }
}
