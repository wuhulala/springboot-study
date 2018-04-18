package com.wuhulala.springboot.transcation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 功能说明: com.wuhulala.springboot.transcation<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@MapperScan(basePackages = "com.wuhulala.springboot.transcation.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class TransactionTestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionTestSpringBootApplication.class, args);
    }

}
