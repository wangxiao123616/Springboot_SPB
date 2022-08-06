package com.soft.spb;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
@MapperScan("com.soft.spb.mapper")
public class SpbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbApplication.class, args);
        log.info("[系统初始化完毕]");
    }

    @Bean
    public PaginationInnerInterceptor  paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }

}
