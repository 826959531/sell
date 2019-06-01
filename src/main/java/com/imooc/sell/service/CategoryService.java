package com.imooc.sell.service;

import com.imooc.sell.domain.ProductCategory;

import java.util.List;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>接口名称：CategoryService
 * <dd>接口功能：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/20
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
public interface CategoryService {
    /**
     * 通过id查询类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目编号查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增和修改
     * @param category
     * @return
     */
    ProductCategory save(ProductCategory category);

}
