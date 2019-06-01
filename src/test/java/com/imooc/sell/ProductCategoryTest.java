package com.imooc.sell;

import com.imooc.sell.domain.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：ProductCategoryTest
 * <dd>类描述：
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void testProductCategoryGet(){
        Optional<ProductCategory> optionalProductCategory = repository.findById(1);
        ProductCategory productCategory = optionalProductCategory.get();
        System.out.println(productCategory);
    }

    @Test
    public void testProductCategorySave(){
        ProductCategory category = new ProductCategory();
        category.setCategoryId(4);
        category.setCategoryName("今日热卖2");
        category.setCategoryType(2);
        repository.save(category);
    }


    @Test
    public void testProductCategoryDelete(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(5);
        repository.delete(productCategory);
    }

    @Test
    public void testProductCategoryUpdate(){
        ProductCategory category = new ProductCategory();
        category.setCategoryId(6);
        category.setCategoryName("年轻最爱");
        repository.save(category);
    }

    @Test
    public void testProductCategoryFind(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,2,3,4);
        List<ProductCategory> categories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(null,categories);
    }
}