package com.imooc.sell.service.impl;

import com.imooc.sell.domain.OrderDetail;
import com.imooc.sell.dto.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    @Test
    public void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("廖师兄");
        orderDto.setBuyerAddress("生命科学院");
        orderDto.setBuyerPhone("18866668888");
        orderDto.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> list = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2019052766668");
        orderDetail.setOrderId("2019052766667");
        orderDetail.setProductIcon("http://123456.jpg");
        orderDetail.setProductId("000002");
        orderDetail.setProductName("燕窝");
        orderDetail.setProductPrice(new BigDecimal(388));
        orderDetail.setProductQuantity(1);


        list.add(orderDetail);
        orderDto.setOrderDetailList(list);

        OrderDto dto = orderService.create(orderDto);

        System.out.println(dto);

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}