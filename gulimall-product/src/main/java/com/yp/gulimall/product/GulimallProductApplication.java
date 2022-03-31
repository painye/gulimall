package com.yp.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、整合MyBatis-plus
 *      1)、导入依赖  mybatis-plus-boot-starter
 *      2)、配置
 *          1、配置数据源
 *              1）、导入数据库的驱动
 *              2）、在application.yml中配置数据源相关信息
 *
 * 2、逻辑删除
 *  1）、配置逻辑删除的全局规则
 *  2）、配置逻辑删除的组件bean
 *  3）、加上逻辑及删除注解@TableLogic
 */


@SpringBootApplication
@MapperScan("com.yp.gulimall.product.dao")
@EnableDiscoveryClient
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
