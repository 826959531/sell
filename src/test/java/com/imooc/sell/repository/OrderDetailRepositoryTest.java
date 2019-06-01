package com.imooc.sell.repository;

import com.imooc.sell.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("2019052766666");
        System.out.println(orderDetailList);
    }

    @Test
    public void saveTest() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2019052766667");
        orderDetail.setOrderId("2019052766667");
        orderDetail.setProductIcon("http://123456.jpg");
        orderDetail.setProductId("000001");
        orderDetail.setProductName("燕窝");
        orderDetail.setProductPrice(new BigDecimal(388));
        orderDetail.setProductQuantity(1);
        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotEquals(null,detail);
    }
}