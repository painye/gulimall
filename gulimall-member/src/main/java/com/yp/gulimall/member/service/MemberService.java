package com.yp.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.common.utils.PageUtils;
import com.yp.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:18:36
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

