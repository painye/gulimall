package com.yp.gulimall.product.service.impl;

import com.yp.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.yp.gulimall.product.dao.AttrGroupDao;
import com.yp.gulimall.product.dao.CategoryDao;
import com.yp.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.yp.gulimall.product.entity.AttrGroupEntity;
import com.yp.gulimall.product.entity.CategoryEntity;
import com.yp.gulimall.product.service.CategoryService;
import com.yp.gulimall.product.vo.AttrRespVo;
import com.yp.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.common.utils.PageUtils;
import com.yp.common.utils.Query;

import com.yp.gulimall.product.dao.AttrDao;
import com.yp.gulimall.product.entity.AttrEntity;
import com.yp.gulimall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao relationDao;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        //1、保存基本数据
        this.save(attrEntity);
        //2、保存关联关系
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrGroupId(attr.getAttrGroupId());
        relationEntity.setAttrId(attrEntity.getAttrId());
        relationDao.insert(relationEntity);
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();

        if(catelogId != 0){
            queryWrapper.eq("catelog_id", catelogId);
        }
        String key=(String) params.get("key");
        if(!StringUtils.isEmpty(key)){
            queryWrapper.and((wrapper)->{
                wrapper.eq("attr_id",key).or().like("attr_name", key);
            });
        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );
        PageUtils pageUtils= new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> attrRespVos= records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);

            //1、设置分类和分组的名字
            /**
             *1、1拿到属性分组的名字：
             *      因为属性表中没有属性分组的信息，只有关联表中才有属性分组id
             *      1、先根据属性的id查找属性与属性分组的关联表，找到关联的属性分组id
             *      2、根据属性id查属性分子表获取属性分组名，
             * 2、直接在属性的实体类中拿到分类id
             * 3、根据分类id查找分类表获取分类名
             */
            AttrAttrgroupRelationEntity relationEntity = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));
           if(relationEntity != null){
               AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
               attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
           }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
           if(categoryEntity != null){
               attrRespVo.setCatelogName(categoryEntity.getName());
           }
            return attrRespVo;
        }).collect(Collectors.toList());
        pageUtils.setList(attrRespVos);
        return pageUtils;

    }

    @Override
    public AttrRespVo getAttrInfo(Long attrId) {
        AttrRespVo respVo = new AttrRespVo();
        //根据id获得属性实体类
        AttrEntity attrEntity = this.getById(attrId);
        //利用工具类将attrEntity中的属性复制到respVo中去
        BeanUtils.copyProperties(attrEntity, respVo);

        //1、根据属性id查询属性属性分组关联表,设置分组信息
        AttrAttrgroupRelationEntity attrgroupRelation = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrId));
        if(attrgroupRelation != null){
            respVo.setAttrGroupId(attrgroupRelation.getAttrGroupId());
            AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrgroupRelation.getAttrGroupId());
            if(attrGroupEntity != null){
                respVo.setGroupName(attrGroupEntity.getAttrGroupName());
            }
        }

        //2、设置分类信息
        Long catelogId = attrEntity.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);
        respVo.setCatelogPath(catelogPath);

        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if(categoryEntity != null){
            respVo.setCatelogName(categoryEntity.getName());
        }
        return respVo;




    }

}