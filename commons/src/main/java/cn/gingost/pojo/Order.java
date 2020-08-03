package cn.gingost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 19:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private User user;
    private List<Item> items;
}
