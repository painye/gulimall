package com.yp.common.to;
/**
 * @author pan
 * @date 2022/4/5 16:43
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName : com.yp.common.to.SkuReductionTo
 * @Description : 类描述
 * @author pan
 * @date 2022/4/5 16:43
 */
@Data
public class SkuReductionTo {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrices;
}
