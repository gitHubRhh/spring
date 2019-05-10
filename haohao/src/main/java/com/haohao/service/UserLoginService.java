package com.haohao.service;

import com.haohao.entity.User;


public interface UserLoginService {


    //用户登录
    public User userLogin(String username, String password);

    //注册新用户
    public int adduser(String username,String password,int age);

}
