package com.mengfou.service;

import com.mengfou.entity.ServerResponse;

/**
 * @author 梦否
 * @date 2022/05/06 10:44
 */
public interface IDownloadNovelImageService {

    void startDownloadImages();
    ServerResponse<String> startDownloadImageById(String bid);
}
