package com.liushao.user.controller;

import com.liushao.entity.Result;
import com.liushao.entity.StatusCode;
import com.liushao.user.pojo.User;
import com.liushao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User result = userService.login(user);

        if (result != null) {
            return new Result(true, StatusCode.OK, "登录成功", result);
        }

        return new Result(false, StatusCode.OK, "登录失败");
    }
}
