package com.imooc.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SellApplication {

    @PostConstruct
    void started() {
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

}
