package com.soft.spb;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan(value = "com.soft.spb.mapper")
@SpringBootApplication(scanBasePackages = {"com.soft.spb"})
public class SpbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbApplication.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
