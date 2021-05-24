package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ButtonsController {
    @GetMapping("/buttons")
    public String buttons(){
        return "ui/buttons";
    }
}
