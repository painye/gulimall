package com.yp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 17:56:22
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

