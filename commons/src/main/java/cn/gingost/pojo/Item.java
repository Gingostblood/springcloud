package cn.gingost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 19:41
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Integer id;
    private String name;
    private Integer number;
}
