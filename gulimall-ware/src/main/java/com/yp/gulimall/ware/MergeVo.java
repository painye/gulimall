package com.yp.gulimall.ware;
/**
 * @author pan
 * @date 2022/4/6 15:23
 */

import lombok.Data;

import java.util.List;

/**
 * @ClassName : com.yp.gulimall.ware.MergeVo
 * @Description : 类描述
 * @author pan
 * @date 2022/4/6 15:23
 */

@Data
public class MergeVo {

    private Long purchaseId;    //整单id
    private List<Long> items;   //合并项几何

}
