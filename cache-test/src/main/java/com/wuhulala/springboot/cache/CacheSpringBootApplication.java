package com.wuhulala.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 功能说明: com.wuhulala.springboot.cache<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/20<br>
 */
@SpringBootApplication
@EnableCaching
public class CacheSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSpringBootApplication.class, args);
    }

}
