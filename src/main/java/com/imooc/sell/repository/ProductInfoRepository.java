package com.imooc.sell.repository;

import com.imooc.sell.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>接口名称：ProductInfoRepository
 * <dd>接口功能：
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
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /**
     * 查询上架商品
     * @param ProductStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer ProductStatus);
}
