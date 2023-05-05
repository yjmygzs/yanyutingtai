package com.example.yanyutingtai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.yanyutingtai.dao")
public class YanyutingtaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanyutingtaiApplication.class, args);
    }

}
