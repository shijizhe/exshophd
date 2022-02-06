package com.jizhe.exshophd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jizhe.exshophd.mapper")
public class ExshophdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExshophdApplication.class, args);
    } 

}
