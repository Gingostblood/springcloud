package cn.gingost.service;

import cn.gingost.pojo.Order;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:05
 **/
public interface OrderService {

    //查询订单
    Order getOrder(String orderId);

    //添加订单
    void addOrder(Order order);
}
