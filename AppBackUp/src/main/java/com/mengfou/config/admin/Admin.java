package com.mengfou.config.admin;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "admin")
@PropertySource(value = {"classpath:admin-config.yaml"}, encoding = "utf-8", factory = AdminFactory.class)
@Data
public class Admin {
    private String userName;
    private String passwd;
}