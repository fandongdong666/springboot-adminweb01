package com.fan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormContrller {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    @GetMapping("/form_advanced_components")
    public String form_advanced_components(){
        return "form/form_advanced_components";
    }
    @GetMapping("/form_wizard")
    public String form_wizard(){
        return "form/form_wizard";
    }
    @GetMapping("/form_validation")
    public String form_validation(){
        return "form/form_validation";
    }
    @GetMapping("/editors")
    public String editors(){
        return "form/editors";
    }
    @GetMapping("/inline_editors")
    public String inline_editors(){
        return "form/inline_editors";
    }
    @GetMapping("/pickers")
    public String pickers(){
        return "form/pickers";
    }
    @GetMapping("/dropzone")
    public String dropzone(){
        return "form/dropzone";
    }
    //文件上传
    @PostMapping("/upload")
    public String upload(
            @RequestParam("email") String email,
            @RequestParam("uploadusername") String uploadusername,
            @RequestParam("headerimg") MultipartFile headerimg,
            @RequestParam("photos") MultipartFile[] photos
            ) throws IOException {
        log.info("上传的信息：email={},uploadusername={},headerimg={},photos={}",
                email,uploadusername,headerimg,photos.length);
        //单文件上传
        if(!headerimg.isEmpty()){
            //保存到文件服务器
            String originalFilename = headerimg.getOriginalFilename();
            //注意a文件夹要存在的
            headerimg.transferTo(new File("g:\\a\\"+originalFilename));
        }
        //多文件上传
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    //注意a文件夹要存在的
                    photo.transferTo(new File("g:\\a\\"+originalFilename));
                }
            }
        }
        return "index";
    }
}
