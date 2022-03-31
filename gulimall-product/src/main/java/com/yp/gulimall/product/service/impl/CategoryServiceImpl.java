package com.yp.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.common.utils.PageUtils;
import com.yp.common.utils.Query;

import com.yp.gulimall.product.dao.CategoryDao;
import com.yp.gulimall.product.entity.CategoryEntity;
import com.yp.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构
        //2、1找出所有一级分类
        List<CategoryEntity> leve1Menus = entities.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu)->{
            menu.setChildren(getChildrenS(menu, entities));
            return menu;
        }).sorted((menu1, menu2)->{
            return (menu1.getSort() == null?0:menu1.getSort()) - (menu2.getSort()==null ?0:menu2.getSort());
        }).collect(Collectors.toList());
        return leve1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前删除的菜单，是否被别的地方引用

        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 递归找到当前菜单的所有子菜单
     * @param root：当前菜单
     * @param all：全体菜单
     * @return children: root的所有子菜单
     */
    private List<CategoryEntity> getChildrenS(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity->{
            //1、找到子菜单，递归
            categoryEntity.setChildren(getChildrenS(categoryEntity, all));
            return categoryEntity;
            //2、排序
        }).sorted((menu1, menu2)->{
            return (menu1.getSort() == null?0:menu1.getSort()) - (menu2.getSort()==null ?0:menu2.getSort());
        }).collect(Collectors.toList());
        return  children;
    }

}