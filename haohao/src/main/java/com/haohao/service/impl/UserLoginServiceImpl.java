package com.haohao.service.impl;

import com.haohao.dao.UserMapper;
import com.haohao.entity.User;
import com.haohao.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper ;

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public User userLogin(String username, String password) {
        User user = usermapper.userlogin(username,password);
        return user;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param age
     * @return
     */
    @Override
    public int adduser(String username, String password, int age) {
        return usermapper.adduser(username,password,age);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }
}
