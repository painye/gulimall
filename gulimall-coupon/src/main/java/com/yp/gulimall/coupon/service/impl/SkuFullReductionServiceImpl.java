package com.yp.gulimall.coupon.service.impl;

import com.yp.common.to.MemberPrice;
import com.yp.common.to.SkuReductionTo;
import com.yp.gulimall.coupon.entity.MemberPriceEntity;
import com.yp.gulimall.coupon.entity.SkuLadderEntity;
import com.yp.gulimall.coupon.service.MemberPriceService;
import com.yp.gulimall.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.common.utils.PageUtils;
import com.yp.common.utils.Query;

import com.yp.gulimall.coupon.dao.SkuFullReductionDao;
import com.yp.gulimall.coupon.entity.SkuFullReductionEntity;
import com.yp.gulimall.coupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    SkuLadderService skuLadderService;

    @Autowired
    SkuFullReductionService skuFullReductionService;

    @Autowired
    MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        //打折、满减、优惠
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        //优惠叠加
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());
        //是否打折
        skuLadderEntity.setDiscount(skuReductionTo.getDiscount());
        //是否满减
        skuLadderEntity.setFullCount(skuReductionTo.getFullCount());
        skuLadderEntity.setSkuId(skuReductionTo.getSkuId());
        if(skuReductionTo.getFullCount()>0){
            skuLadderService.save(skuLadderEntity);
        }

        //sms_sku_full_reduction
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo, reductionEntity);
        if(reductionEntity.getFullPrice().compareTo(new BigDecimal("0"))==1){
            this.save(reductionEntity);
        }

        //3、sms_member_price
        List<MemberPrice> memberPrice = skuReductionTo.getMemberPrices();

        if(memberPrice!=null && memberPrice.size()>0){
            List<MemberPriceEntity> collect = memberPrice.stream().map(item -> {
                MemberPriceEntity priceEntity = new MemberPriceEntity();
                priceEntity.setSkuId(skuReductionTo.getSkuId());
                priceEntity.setMemberLevelId(item.getId());
                priceEntity.setMemberLevelName(item.getName());
                priceEntity.setAddOther(1);
                return priceEntity;
            }).filter(item->{
                return item.getMemberPrice().compareTo(new BigDecimal("0")) == 1;
            }).collect(Collectors.toList());
            memberPriceService.saveBatch(collect);
        }




    }

}