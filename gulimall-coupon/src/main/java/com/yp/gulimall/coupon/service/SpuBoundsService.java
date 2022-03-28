package com.yp.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.coupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:05:37
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

