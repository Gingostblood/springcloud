package cn.gingost.rest;

import cn.gingost.pojo.Item;
import cn.gingost.pojo.Order;
import cn.gingost.pojo.User;
import cn.gingost.service.OrderService;
import cn.gingost.util.JsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:39
 **/

@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        log.info("get order, id=" + orderId);

        Order order = orderService.getOrder(orderId);
        return JsonResult.ok(order);
    }

    @GetMapping("/")
    public JsonResult addOrder() {
        //模拟post提交的数据
        Order order = new Order();
        order.setId("123abc");
        order.setUser(new User(7, null, null));
        order.setItems(Arrays.asList(new Item[]{
                new Item(1, "aaa", 2),
                new Item(2, "bbb", 1),
                new Item(3, "ccc", 3),
                new Item(4, "ddd", 1),
                new Item(5, "eee", 5),
        }));
        orderService.addOrder(order);
        return JsonResult.ok();
    }
}
