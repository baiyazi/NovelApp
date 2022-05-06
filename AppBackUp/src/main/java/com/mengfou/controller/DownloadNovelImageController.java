package com.mengfou.controller;

import com.mengfou.entity.ServerResponse;
import com.mengfou.service.IDownloadNovelImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 梦否
 * @date 2022/05/06 10:44
 */
@Controller
@RequestMapping(value = "/image/")
public class DownloadNovelImageController {

    @Autowired
    IDownloadNovelImageService iDownloadNovelImageService;

    @RequestMapping(value = "download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadImages(){
        iDownloadNovelImageService.startDownloadImages();
    }

    @RequestMapping(value = "download/{bid}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> downloadImage(@PathVariable("bid") String bid){
        return iDownloadNovelImageService.startDownloadImageById(bid);
    }

    @RequestMapping(value = "downloaded/{bid}", method = RequestMethod.GET)
    public String downloadImaged(@PathVariable("bid") String bid, @RequestParam("md5") String md5){
        iDownloadNovelImageService.startDownloadImageById(bid);
        return "forward:/image/" + md5 + ".jpg";
    }



}
