package com.jx.modules;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages ={"com.jx.modules.dao"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
