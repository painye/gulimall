package com.yp.gulimall.product.feign;

import com.yp.common.to.SkuReductionTo;
import com.yp.common.to.SpuBoundTo;
import com.yp.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author pan
 * @date 2022/4/5 16:06
 */

@FeignClient("gulimall-coupon")
@Component
public interface CouponFeginService {

    /**
     * 1、CouponFeignService.saveSpuBounds(SpuBoundTo)
     *  1)、@RequestBody见着个对象转换为json
     *  2）、在nacos注册中兴中找到gulimall-coupon服务，给/coupon/spubounds/save发送请求
     *  3）、对方服务收到请求，请求体里面有josn数据
     *  只要json数据模型是兼容的，双方服务无需使用同一个to
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
