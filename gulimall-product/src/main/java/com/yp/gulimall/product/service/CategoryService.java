package com.yp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 17:56:22
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

