package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 * @author cpq
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"已上架"),
    DOWN(1,"下架")
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
    ProductStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }


}
