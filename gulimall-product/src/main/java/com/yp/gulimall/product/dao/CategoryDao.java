package com.yp.gulimall.product.dao;

import com.yp.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 17:56:22
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
