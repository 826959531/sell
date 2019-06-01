package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 返回给前台的
 * @author cpq
 */
@Getter
public enum ResultEnum {
    /**
     * 返回给前台，商品不存在
     */
    PRODUCT_NOT_EXIST(10,"商品不存在"),

    /**
     * 返回给前台，商品不存在
     */
    PRODUCT_NOT_ENOUGH(11,"商品库存不足"),
    ;

    private Integer code;
    /**
     * 描述
     */
    private String message;

    /**
     *
     * @param code
     * @param message
     */
    ResultEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
