package com.imooc.sell.repository;

import com.imooc.sell.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>接口名称：ProductCategoryRepository
 * <dd>接口功能：
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
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
     * 根据type查询
     * @param categoryList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);


}
