package com.imooc.sell.repository;

import com.imooc.sell.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
        System.out.println(productInfos);
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("000001");
        productInfo.setCategoryType(4);
        productInfo.setProductDescription("健身养生，还能补血，超值划算");
        productInfo.setProductPrice(new BigDecimal(388));
        productInfo.setProductName("燕窝");
        productInfo.setProductStatus(0);
        productInfo.setProductStock(999);
        productInfo.setProductIcon("http://heiheihei.jpg");
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
}