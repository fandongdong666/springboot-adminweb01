package com.fan.controller;

import com.fan.domain.LoginUser;
import com.fan.service.LoginUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginUserController {
    @Resource
    LoginUserService loginUserService;

    @GetMapping({"/login","/"})
    public String toLogin(){

        return "login";
    }

    @PostMapping("/login")
    public String longin(String username, String password, Model model, HttpSession session){
        LoginUser loginUser = loginUserService.getLoginUserByNameAndPassword(username, password);
        if(loginUser!= null){
            System.out.println(loginUser);
            session.setAttribute("loginUser",loginUser);
            return "redirect:/index.html";//这是一个转发，地址栏不会变（缺陷）
        }else{
            //没有登录成功，饿哦们带一些数据给login页面
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
        //要拦截判断
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!= null){
            return "index";
        }else{
            model.addAttribute("msg","未登录，请重新登录");
            return "login";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        return "redirect:/login";
    }


}
