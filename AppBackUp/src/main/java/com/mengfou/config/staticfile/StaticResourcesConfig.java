package com.mengfou.config.staticfile;

import com.mengfou.config.download.DownloadPathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 梦否
 * @date 2022/05/06 13:34
 */
@Configuration
public class StaticResourcesConfig implements WebMvcConfigurer {

    @Autowired
    DownloadPathConfig downloadPathConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("**********Path: " + downloadPathConfig.getAccessPath() +
                ", ***accessPath: " + downloadPathConfig.getFilePath());

        registry.addResourceHandler(downloadPathConfig.getAccessPath())
                .addResourceLocations("file:" + downloadPathConfig.getFilePath());

        registry.addResourceHandler("/static/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}
