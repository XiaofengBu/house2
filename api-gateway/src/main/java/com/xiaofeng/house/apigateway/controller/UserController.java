/**
 * 
 */
package com.xiaofeng.house.apigateway.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xiaofeng.house.apigateway.common.RestResponse;
import com.xiaofeng.house.apigateway.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric
 *
 */
@RestController
public class UserController {
  
  
  @Autowired
  private UserDao userDao;

  @RequestMapping(value="test",method={RequestMethod.POST,RequestMethod.GET})
  public RestResponse<String> accountsSubmit(){
    return userDao.test();
  }

}
