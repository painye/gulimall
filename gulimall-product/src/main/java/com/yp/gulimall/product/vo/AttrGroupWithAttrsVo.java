package com.yp.gulimall.product.vo;
/**
 * @author pan
 * @date 2022/4/4 22:47
 */

import com.baomidou.mybatisplus.annotation.TableId;
import com.yp.gulimall.product.entity.AttrEntity;
import lombok.Data;
import sun.plugin.dom.core.Attr;

import java.util.List;

/**
 * @ClassName : com.yp.gulimall.product.vo.AttrGroupWithAttrsVo
 * @Description : 类描述
 * @author pan
 * @date 2022/4/4 22:47
 */
@Data
public class AttrGroupWithAttrsVo {
    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;

}
