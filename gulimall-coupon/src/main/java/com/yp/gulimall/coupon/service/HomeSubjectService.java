package com.yp.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:05:37
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

