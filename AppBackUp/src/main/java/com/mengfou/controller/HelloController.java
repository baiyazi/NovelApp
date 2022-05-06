package com.mengfou.controller;

import com.mengfou.config.admin.Admin;
import com.mengfou.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    IHelloService iHelloService;

    @RequestMapping("/")
    public String home(){
        return iHelloService.hello();
    }

    @RequestMapping("/admin")
    public Admin getAdmin() {
        return iHelloService.getAdmin();
    }
}
