package com.mengfou.config.download;

import com.mengfou.config.admin.AdminFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 梦否
 * @date 2022/05/06 12:21
 */
@Component
@ConfigurationProperties(prefix = "localimage")
public class DownloadPathConfig {
    private String filePath;
    private String accessPath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }
}
