package com.mengfou.controller;

import com.mengfou.config.admin.Admin;
import com.mengfou.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    IHelloService iHelloService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String home(){
        return iHelloService.hello();
    }

    @RequestMapping("/admin")
    @ResponseBody
    public Admin getAdmin() {
        return iHelloService.getAdmin();
    }
}
