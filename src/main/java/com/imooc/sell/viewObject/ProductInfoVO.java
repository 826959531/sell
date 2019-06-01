package com.imooc.sell.viewObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：ProductInfoVO
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/22
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@Data
public class ProductInfoVO {
    /**
     * 商品id
     */
    @JsonProperty("id")
    private String productId;
    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;
    /**
     * 商品价格
     */
    @JsonProperty("price")
    private BigDecimal productPrice;
    /**
     * 商品描述
     */
    @JsonProperty("description")
    private String productDescription;
    /**
     * 商品小图地址
     */
    @JsonProperty("icon")
    private String productIcon;

}
