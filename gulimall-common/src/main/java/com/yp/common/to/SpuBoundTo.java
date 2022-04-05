package com.yp.common.to;
/**
 * @author pan
 * @date 2022/4/5 16:11
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : com.yp.common.to.SpuBoundTo
 * @Description : 类描述
 * @author pan
 * @date 2022/4/5 16:11
 */

@Data
public class SpuBoundTo {

    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}
