package com.mxz.yiban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mxz.yiban.dao")
public class YibanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YibanApplication.class, args);
    }

}
