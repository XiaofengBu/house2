package com.xiaofeng.house.userserver.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHanlder {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHanlder.class);
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	public RestResponse<Object> handler(HttpServletRequest req, Throwable throwable){
		LOGGER.error(throwable.getMessage(),throwable);
		RestCode restCode = Exception2CodeRepo.getCode(throwable);
		RestResponse<Object> response = new RestResponse<Object>(restCode.code,restCode.msg);
		return response;
	}
	
}
