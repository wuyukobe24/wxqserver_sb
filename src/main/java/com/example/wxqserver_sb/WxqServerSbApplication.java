package com.example.wxqserver_sb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wxqserver_sb.mapper")
public class WxqServerSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxqServerSbApplication.class, args);
    }

}
