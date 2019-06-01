package com.imooc.sell.repository;

import com.imooc.sell.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>接口名称：OrderDetailRepository
 * <dd>接口功能：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/27
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 根据订单的id查询
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
