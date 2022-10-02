package com.shiro.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class PermissonsException {
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExcepion(Exception e){
        return "无权限";
    }

    @ResponseBody
    @ExceptionHandler(AuthenticationException.class)
    public String authenticationException(Exception e){
        return "权限认证失败";
    }
}
