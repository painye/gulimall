package com.yp.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.yp.gulimall.ware.MergeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yp.gulimall.ware.entity.PurchaseEntity;
import com.yp.gulimall.ware.service.PurchaseService;
import com.yp.common.utils.PageUtils;
import com.yp.common.utils.R;



/**
 * 采购信息
 *
 * @author painye
 * @email sunlightcs@gmail.com
 * @date 2022-03-28 21:38:19
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;


    @PostMapping("/merge")
    public R merge(@RequestBody MergeVo mergeVo){

        purchaseService.mergePurchase(mergeVo);
        return R.ok();
    }

    /**
     * 未分配的列表
     */
    @RequestMapping("/unreceive/list")
    //@RequiresPermissions("ware:purchase:list")
    public R unReceiveList(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPageUnReceivePurchase(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchase:info")
    public R info(@PathVariable("id") Long id){
		PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchase:save")
    public R save(@RequestBody PurchaseEntity purchase){
		purchase.setUpdateTime(new Date());
		purchase.setCreateTime(new Date());
        purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchase:update")
    public R update(@RequestBody PurchaseEntity purchase){
		purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchase:delete")
    public R delete(@RequestBody Long[] ids){
		purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
