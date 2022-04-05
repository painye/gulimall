package com.yp.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
 *
 *
 *  3、JSR303
 *      1）、给Bean添加注解：javax.validation.constraints,并定义自己的message提示
 *      2）、开启校验功能@valid
 *          效果： 检验错误后会有默认的响应
 *      3）、给校验的Bean后紧跟一个BindingResult，就可以获取到校验的结果
 *      4）、分组校验
 *          1）、@NotBlank(message="品牌名必须提交", groups = {AddGroup.class,...})
 *              给校验注解标注什么情况需要进行校验
 *          2)、@Validated{(AddGroup.class)}
 *          3)、默认没有指定分组的校验注解@NotBlank,在分组校验情况下不生效
 */


@EnableTransactionManagement
@EnableFeignClients(basePackages = "com.yp.gulimall.product.feign")
@SpringBootApplication
@MapperScan("com.yp.gulimall.product.dao")
@EnableDiscoveryClient
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
