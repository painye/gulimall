package com.yp.gulimall.coupon.feign;
/**
 * @author pan
 * @date 2022/3/29 8:11
 */

import com.yp.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : com.yp.gulimall.coupon.feign.CouponFeignService
 * @Description : 类描述
 * @author pan
 * @date 2022/3/29 8:11
 */
@Component
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
