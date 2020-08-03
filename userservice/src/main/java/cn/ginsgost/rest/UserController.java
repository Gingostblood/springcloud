package cn.ginsgost.rest;

import cn.gingost.pojo.User;
import cn.gingost.service.UserService;
import cn.gingost.util.JsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lezzy
 * @description
 * @data 2020/8/3 20:50
 **/

@RestController
@Slf4j
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        log.info("get user, userId=" + userId);
        User u = userService.getUser(userId);
        return JsonResult.ok(u);
    }

    @GetMapping("/{userId}/score")
    public JsonResult addScore(
            @PathVariable Integer userId, Integer score) {
        userService.addScore(userId, score);
        return JsonResult.ok();
    }
}
