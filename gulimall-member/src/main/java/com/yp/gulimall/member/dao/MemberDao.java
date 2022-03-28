package com.yp.gulimall.member.dao;

import com.yp.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:18:36
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
