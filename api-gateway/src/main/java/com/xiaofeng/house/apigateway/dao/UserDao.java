package com.xiaofeng.house.apigateway.dao;


import com.xiaofeng.house.apigateway.common.RestResponse;
import com.xiaofeng.house.apigateway.config.GenericRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

  @Autowired
  private GenericRest rest;

  public RestResponse<String> test(){
    ResponseEntity<RestResponse<String>> resultEntity =
            rest.post("http://user/user/test",null, new ParameterizedTypeReference<RestResponse<String>>() {});
    RestResponse<String> restResponse = resultEntity.getBody();
    return restResponse;
  }
}
