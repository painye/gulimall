package com.yp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.product.entity.BrandEntity;
import com.yp.gulimall.product.entity.CategoryBrandRelationEntity;
import com.yp.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 17:56:22
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    /**
     * 级联修改分类的关联表
     * @param catId
     * @param name
     */
    void updateCategory(Long catId, String name);

    List<BrandEntity> getBrandsByCatId(Long catId);
}

