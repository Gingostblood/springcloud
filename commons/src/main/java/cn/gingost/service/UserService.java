package cn.gingost.service;

import cn.gingost.pojo.User;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:05
 **/

public interface UserService {

    //查询用户
    User getUser(Integer id);

    //增加积分
    void addScore(Integer id, Integer score);
}
