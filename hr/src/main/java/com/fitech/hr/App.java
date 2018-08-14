package com.fitech.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App .class, args);
        System.out.println("项目启动成功?!!!!?##?");
        System.out.println("测试拉取eee");
    }
}