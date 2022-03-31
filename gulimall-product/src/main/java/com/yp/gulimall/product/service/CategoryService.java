package com.yp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.product.entity.CategoryEntity;

import java.util.List;
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


    /**
     * 返回按级别划分的树形结构
     * @return
     */
    List<CategoryEntity> listWithTree();

    /**
     * 根据id删除菜单
     * @param asList 存有待删除的菜单id的数组
     */
    void removeMenuByIds(List<Long> asList);
}

