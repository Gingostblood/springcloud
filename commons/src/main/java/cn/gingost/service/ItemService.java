package cn.gingost.service;

import cn.gingost.pojo.Item;

import java.util.List;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:03
 **/
public interface ItemService {

    //查询订单中的商品列表
    List<Item> getItems(String orderId);

    //减少商品的库存
    void decreaseNumbers(List<Item> list);
}
