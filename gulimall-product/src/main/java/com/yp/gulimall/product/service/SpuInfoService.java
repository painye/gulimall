package com.yp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.product.entity.SpuInfoDescEntity;
import com.yp.gulimall.product.entity.SpuInfoEntity;
import com.yp.gulimall.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 17:56:22
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);
}

