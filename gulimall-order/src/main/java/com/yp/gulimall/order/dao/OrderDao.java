package com.yp.gulimall.order.dao;

import com.yp.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:28:32
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
