package com.imooc.sell.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：ProductInfo
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/21
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@Entity
@Data
@ToString
public class ProductInfo implements Serializable {

    @Id
    private String productId;
    /**
     * 名称
     */
    private String productName;
    /**
     * 价格
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 状态 0正常  1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
