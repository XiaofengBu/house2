package com.xiaofeng.house.userserver.controller;

import java.util.List;

import com.xiaofeng.house.userserver.common.RestResponse;
import com.xiaofeng.house.userserver.model.User;
import com.xiaofeng.house.userserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;
  //-------------------查询---------------------

  @RequestMapping("getById")
  public RestResponse<User> getUserById(Long id){
    User user = userService.getUserById(id);
    return RestResponse.success(user);
  }

  @RequestMapping("getList")
  public RestResponse<List<User>> getUserList(@RequestBody User user){
    List<User> users = userService.getUserByQuery(user);
    return RestResponse.success(users);
  }
    //----------------------注册----------------------------------
    @RequestMapping("add")
    public RestResponse<User> add(@RequestBody User user){
        userService.addAccount(user,user.getEnableUrl());
        return RestResponse.success();
    }

    /**
     * 主要激活key的验证
     */
    @RequestMapping("enable")
    public RestResponse<Object> enable(String key){
        userService.enable(key);
        return RestResponse.success();
    }

}
