package com.yp.gulimall.coupon.dao;

import com.yp.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:05:37
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
