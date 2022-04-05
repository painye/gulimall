package com.yp.common.constant;
/**
 * @author pan
 * @date 2022/4/3 20:42
 */

/**
 * @ClassName : com.yp.common.constant.ProductConstant
 * @Description : 类描述
 * @author pan
 * @date 2022/4/3 20:42
 */
public class ProductConstant {

    public enum AttrEnum{
        ATTR_TYPE_BASE(1, "基本属性"),ATTR_TYPE_SALE(0,"销售属性");
        private int code;
        private String msg;

        AttrEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode(){
            return code;
        }

        public String getMsg(){
            return msg;
        }
    }
}
