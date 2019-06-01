package com.imooc.sell.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：CartDto
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/29
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@Data
public class CartDto implements Serializable {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDto() {
    }

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
