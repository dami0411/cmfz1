package com.baizhi.yym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yamin on 2018/7/4.
 */
@SpringBootApplication
@MapperScan("com.baizhi.yym.dao")
public class AppEnter {
    public static void main(String[] args) {
        SpringApplication.run(AppEnter.class,args);
    }

}
