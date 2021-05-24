package com.fan.controller;


import com.fan.entity.User;
import com.fan.service.IUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fan
 * @since 2021-05-07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping("/testWrapper")
    public String testWrapper(
            @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
            @RequestParam(required = true,defaultValue = "5",value = "pageSize")Integer pageSize,
            User user,
            Model model
    ){
        return "";
    }

}
