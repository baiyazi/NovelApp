package com.mengfou.service;

import com.mengfou.entity.LeaderBoard;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author 梦否
 * @date 2022/05/06 13:25
 */

public interface ILoadLocalImageService {
    Pair<String, String> getImageURLById(LeaderBoard leaderBoard);
    Map<String, String> getImageURLs(List<LeaderBoard> allLeaderBoards);
}
