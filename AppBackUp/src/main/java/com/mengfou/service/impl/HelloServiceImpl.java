package com.mengfou.service.impl;

import com.mengfou.config.admin.Admin;
import com.mengfou.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;

/**
 * @author 梦否
 * @date 2022/05/05 20:43
 */
// 添加到容器
@Service("iHelloService")
@ConditionalOnClass({Admin.class})
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private Admin admin;

    @Override
    public String hello() {
        return "Hello!";
    }

    @Override
    public Admin getAdmin() {
        return admin;
    }
}
