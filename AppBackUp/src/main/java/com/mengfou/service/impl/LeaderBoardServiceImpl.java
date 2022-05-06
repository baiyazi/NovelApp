package com.mengfou.service.impl;

import com.mengfou.dao.LeaderBoardMapper;
import com.mengfou.entity.LeaderBoard;
import com.mengfou.service.ILeaderBoradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/05 21:19
 */
@Service("iLeaderBoradService")
public class LeaderBoardServiceImpl implements ILeaderBoradService {

    @Autowired
    LeaderBoardMapper leaderBoardMapper;

    @Override
    public List<LeaderBoard> getLeaderBoardDatas(int currentPage, int limit) {
        return leaderBoardMapper.selectByTurnPage((currentPage - 1) * limit, limit);
    }

    @Override
    public LeaderBoard getLeaderBoardById(String id) {
        return leaderBoardMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> getNovelIds() {
        return leaderBoardMapper.getNovelIds();
    }

    @Override
    public List<LeaderBoard> getAllLeaderBoards() {
        return leaderBoardMapper.getAllLeaderBoards();
    }
}
