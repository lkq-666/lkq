package com.wwt.wwt_crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.wwt.wwt_crm.mapper")
@SpringBootApplication
public class WwtCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwtCrmApplication.class, args);
    }

}
