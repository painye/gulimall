package com.yp.gulimall.product.vo;
/**
 * @author pan
 * @date 2022/4/3 16:36
 */

import lombok.Data;

/**
 * @ClassName : com.yp.gulimall.product.vo.AttrRespVo
 * @Description : 类描述
 * @author pan
 * @date 2022/4/3 16:36
 */
@Data
public class AttrRespVo extends AttrVo {
    /**
     * catelogName: "手机、数码。手机"， 所属分类的名字
     * groupName:   "主体", 所属分组名字
     */

    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
