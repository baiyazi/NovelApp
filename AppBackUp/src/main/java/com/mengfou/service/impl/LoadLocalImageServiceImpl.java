package com.mengfou.service.impl;

import com.mengfou.config.server.ServerConfig;
import com.mengfou.entity.LeaderBoard;
import com.mengfou.service.ILoadLocalImageService;
import com.mengfou.utils.MD5;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 梦否
 * @date 2022/05/06 13:25
 */
@Service("iLoadLocalImageService")
public class LoadLocalImageServiceImpl implements ILoadLocalImageService {

    @Autowired
    ServerConfig serverConfig;

    @Override
    public Pair<String, String> getImageURLById(LeaderBoard leaderBoard) {
        String url = "/" + MD5.MD5EncodeUtf8(leaderBoard.getPicurl()) + ".jpg";
        return new Pair<>(leaderBoard.getId(), url);
    }

    @Override
    public Map<String, String> getImageURLs(List<LeaderBoard> allLeaderBoards) {
        Map<String, String> result = new HashMap<>();
        for (LeaderBoard leaderBoard : allLeaderBoards) {
            String url = serverConfig.getLocalURL() + "/image/" + MD5.MD5EncodeUtf8(leaderBoard.getPicurl()) + ".jpg";
            result.put(leaderBoard.getId(), url);
        }
        return result;
    }
}
