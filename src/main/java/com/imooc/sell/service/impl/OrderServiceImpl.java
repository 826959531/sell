package com.imooc.sell.service.impl;

import com.imooc.sell.domain.OrderDetail;
import com.imooc.sell.domain.OrderMaster;
import com.imooc.sell.domain.ProductInfo;
import com.imooc.sell.dto.CartDto;
import com.imooc.sell.dto.OrderDto;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.OrderDetailRepository;
import com.imooc.sell.repository.OrderMasterRepository;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.KeyUtil;
import com.mysql.cj.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：OrderServiceImpl
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/28
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderMasterRepository masterRepository;
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository detailRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //查询商品
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算价格  订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());

            detailRepository.save(orderDetail);
        }

        //写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        masterRepository.save(orderMaster);
        //减库存

        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream()
                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productInfoService.decreaseStock(cartDtoList);
        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderDto orderDto = new OrderDto();
        OrderMaster orderMaster = masterRepository.findById(orderId).get();
        BeanUtils.copyProperties(orderMaster,orderDto);
        List<OrderDetail> detailList = detailRepository.findByOrderId(orderId);
        orderDto.setOrderDetailList(detailList);
        log.info("orderDto ： " + orderDto);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        PageRequest pageRequest = new PageRequest(0,10);
        masterRepository.findByBuyerOpenid(buyerOpenid,pageRequest);
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
}
