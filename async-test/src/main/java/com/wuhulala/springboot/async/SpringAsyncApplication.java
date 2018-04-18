package com.wuhulala.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 功能说明: springboot 异步任务测试 <br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/7<br>
 */
@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class SpringAsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncApplication.class, args);
    }
}
