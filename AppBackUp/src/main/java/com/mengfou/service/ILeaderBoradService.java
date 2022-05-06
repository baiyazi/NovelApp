package com.mengfou.service;

import com.mengfou.entity.LeaderBoard;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/05 21:14
 */
public interface ILeaderBoradService {
    List<LeaderBoard> getLeaderBoardDatas(int currentPage, int limit);
    LeaderBoard getLeaderBoardById(String id);
    List<String> getNovelIds();
    List<LeaderBoard> getAllLeaderBoards();
}
