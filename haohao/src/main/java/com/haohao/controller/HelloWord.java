package com.haohao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/hello"})
public class HelloWord {
    @RequestMapping(value = {"print"})
    public String print(){
        System.out.println("进入方法");
        return "HelloWord";
    }


}
