package com.imooc.sell.repository;

import com.imooc.sell.domain.OrderMaster;
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
import java.util.stream.Stream;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid("zheshinideyida",request);
        Assert.assertNotEquals(0,orderMasters.getTotalElements());
    }

    @Test
    public void saveTest() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2019052766667");
        orderMaster.setBuyerName("北盟王庭");
        orderMaster.setBuyerPhone("16666666666");
        orderMaster.setBuyerAddress("南京北锣鼓巷");
        orderMaster.setBuyerOpenid("zheshiwodeyida");
        orderMaster.setOrderAmount(new BigDecimal(6.9));
        orderMaster.setPayStatus(1);
        OrderMaster master = repository.save(orderMaster);
        Assert.assertNotNull(master);

    }



}