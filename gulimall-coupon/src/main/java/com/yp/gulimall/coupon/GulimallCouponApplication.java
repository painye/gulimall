package com.yp.gulimall.coupon;
/**
 * @author pan
 * @date 2022/3/28 21:02
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : com.yp.gulimall.coupon.GulimallCouponApplication
 * @Description : 类描述
 * @author pan
 * @date 2022/3/28 21:02
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class,args);
    }
}
