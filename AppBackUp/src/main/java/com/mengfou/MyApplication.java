package com.mengfou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mengfou.dao")
public class MyApplication {
    public static void main(String[] args) {
        System.out.println("SpringBoot Version: "+SpringBootVersion.getVersion());
        SpringApplication.run(MyApplication.class, args);
    }
}
