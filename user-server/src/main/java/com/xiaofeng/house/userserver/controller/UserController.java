package com.xiaofeng.house.userserver.controller;

import java.util.List;

import com.xiaofeng.house.userserver.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);
  @RequestMapping("test")
  public RestResponse<String> getUserById(Long id){
    logger.info("收到请求");
    return RestResponse.success("调用测试");
  }

  

}
