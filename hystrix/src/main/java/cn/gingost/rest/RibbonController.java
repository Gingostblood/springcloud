package cn.gingost.rest;

import cn.gingost.pojo.Item;
import cn.gingost.pojo.Order;
import cn.gingost.pojo.User;
import cn.gingost.util.JsonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author:lezzy
 * @Date:2020/8/4 10:16
 */

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate rt;

//    @GetMapping("/item-service/{orderId}")
//    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
//        //向指定微服务地址发送 get 请求，并获得该服务的返回结果
//        //{1} 占位符，用 orderId 填充
//        return rt.getForObject("http://localhost:8001/{1}", JsonResult.class, orderId);
//    }
//
//    @PostMapping("/item-service/decreaseNumber")
//    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
//        //发送 post 请求
//        return rt.postForObject("http://localhost:8001/decreaseNumber", items, JsonResult.class);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/user-service/{userId}")
//    public JsonResult<User> getUser(@PathVariable Integer userId) {
//        return rt.getForObject("http://localhost:8101/{1}", JsonResult.class, userId);
//    }
//
//    @GetMapping("/user-service/{userId}/score")
//    public JsonResult addScore(
//            @PathVariable Integer userId, Integer score) {
//        return rt.getForObject("http://localhost:8101/{1}/score?score={2}", JsonResult.class, userId, score);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/order-service/{orderId}")
//    public JsonResult<Order> getOrder(@PathVariable String orderId) {
//        return rt.getForObject("http://localhost:8201/{1}", JsonResult.class, orderId);
//    }
//
//    @GetMapping("/order-service")
//    public JsonResult addOrder() {
//        return rt.getForObject("http://localhost:8201/", JsonResult.class);
//    }

    @GetMapping("/item-service/{orderId}")
    @HystrixCommand(fallbackMethod = "getItemFail")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        //这里服务器路径用 service-id 代替，ribbon 会向服务的多台集群服务器分发请求
        return rt.getForObject("http://item-service/{1}", JsonResult.class, orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return rt.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
    }

    /////////////////////////////////////////

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return rt.getForObject("http://user-service/{1}", JsonResult.class, userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(
            @PathVariable Integer userId, Integer score) {
        return rt.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
    }

    /////////////////////////////////////////

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return rt.getForObject("http://order-service/{1}", JsonResult.class, orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return rt.getForObject("http://order-service/", JsonResult.class);
    }

    public JsonResult<List<Item>> getItemFail(String orderId) {
        return JsonResult.err("获取订单商品列表失败");
    }

}
