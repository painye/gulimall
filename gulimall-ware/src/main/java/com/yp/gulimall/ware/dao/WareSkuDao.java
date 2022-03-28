package com.yp.gulimall.ware.dao;

import com.yp.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:38:19
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
