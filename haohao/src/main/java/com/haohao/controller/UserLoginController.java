package com.haohao.controller;

import com.haohao.entity.User;
import com.haohao.service.UserLoginService;
import com.haohao.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/user"})
public class UserLoginController {
    /**
     * 注入service
     */
    @Autowired
    private UserLoginService userLoginService;


    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping(value = {"/loginHtml"})
    public String loginHtml(){
        return "userLogin";
    }

    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerpage"})
    public String registerpage(){
        return "register";
    }





    /**
     * 用户登陆方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        User user = userLoginService.userLogin(username,password);

        if (user !=null ){
            return "index";
        }
        return "loginError";
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param password1
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          @RequestParam("password1")String password1,
                          @RequestParam("age")int age){
        if (!password.equals(password1)){
            return "两次输入的密码不一致，请确认";
        }else{
            int res = userLoginService.adduser(username,password,age);
            if (res == 0){
                return "注册成功";
            }else {
                return "系统异常，注册失败";
            }
        }

    }

}
