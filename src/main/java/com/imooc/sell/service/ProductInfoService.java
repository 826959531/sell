package com.imooc.sell.service;

import com.imooc.sell.domain.ProductInfo;
import com.imooc.sell.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>接口名称：ProductInfoService
 * <dd>接口功能：
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
public interface ProductInfoService {
    /**
     * 根据查询
     *
     * @param productInfoId
     * @return
     */
    ProductInfo findOne(String productInfoId);

    /**
     * 保存和修改
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 查询上架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 商家查询并分页
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 加库存
     * @param cartDtoList
     */
    void increaseStock(List<CartDto> cartDtoList);
    /**
     * 减库存
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);


}