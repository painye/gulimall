package com.yp.common.exception;
/**
 * @author pan
 * @date 2022/4/1 20:51
 */

/**
 * @ClassName : com.yp.common.exception.BizCodeEnume
 * @Description : 类描述
 * @author pan
 * @date 2022/4/1 20:51
 */
public enum BizCodeEnum {
    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数式校验失败");

    private int code;
    private String msg;
    BizCodeEnum(int code, String msg){
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
