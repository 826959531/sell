package com.imooc.sell.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：ProductCategory
 * <dd>类描述：类目表
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/17
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@Entity
@ToString
@Data
public class ProductCategory implements Serializable {
    /**
     * 类目id
     */
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

}
