package com.mengfou.controller;

import com.mengfou.config.download.DownloadPathConfig;
import com.mengfou.entity.LeaderBoard;
import com.mengfou.service.ILeaderBoradService;
import com.mengfou.service.ILoadLocalImageService;
import com.mengfou.utils.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.*;

/**
 * @author 梦否
 * @date 2022/05/06 13:23
 */
@Controller
@RequestMapping(value = "/image/")
public class LoadLocalImageController {
    private static final Logger logger = LoggerFactory.getLogger(LoadLocalImageController.class);

    @Autowired
    ILoadLocalImageService iLoadLocalImageService;

    @Autowired
    ILeaderBoradService iLeaderBoradService;

    @Autowired
    DownloadPathConfig downloadPathConfig;

    @RequestMapping(value = "load/{bid}", method = RequestMethod.GET)
    public String doLoadImage(@PathVariable("bid") String bid) {
        logger.info("开始加载图片数据！");
        LeaderBoard leaderBoard = iLeaderBoradService.getLeaderBoardById(bid);
        String md5 = MD5.MD5EncodeUtf8(leaderBoard.getPicurl());
        File file = new File(downloadPathConfig.getFilePath() + md5 + ".jpg");
        if (!file.exists()) return "forward:/image/downloaded/" + bid + "?md5=" + md5;
        return "forward:/image/" + md5 + ".jpg";
    }

    @RequestMapping(value = "url", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getAllImageAddress() {
        List<LeaderBoard> allLeaderBoards = iLeaderBoradService.getAllLeaderBoards();
        return iLoadLocalImageService.getImageURLs(allLeaderBoards);
    }
}
