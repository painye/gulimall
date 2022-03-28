package com.yp.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:28:32
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

