package com.imooc.sell.service.impl;

import com.imooc.sell.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo productInfo = service.findOne("000001");
        System.out.println(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("000002");
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("能增进些许内力和气血，适用于练武人群和气血亏空人士");
        productInfo.setProductPrice(new BigDecimal(8888.88));
        productInfo.setProductName("小还丹");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(999);
        productInfo.setProductIcon("http://666.jpg");
        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = service.findUpAll();
        for (ProductInfo productInfo : productInfos) {
            System.out.println(productInfo);
        }
        Assert.assertNotNull(productInfos);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findAll() {
        Pageable pageable = new PageRequest(0,2);
        Page<ProductInfo> page = service.findAll(pageable);
        //System.out.println(page.getTotalElements());
        Stream<ProductInfo> productInfoStream = page.get();
        Object[] objects = productInfoStream.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        //System.out.println(objects);
    }
}