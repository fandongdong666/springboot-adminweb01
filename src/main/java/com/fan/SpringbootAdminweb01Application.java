package com.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.fan.mapper")
@SpringBootApplication(scanBasePackages = "com.fan")
public class SpringbootAdminweb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminweb01Application.class, args);
    }

}
