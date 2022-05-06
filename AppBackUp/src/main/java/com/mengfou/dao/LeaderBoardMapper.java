package com.mengfou.dao;

import com.mengfou.entity.LeaderBoard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LeaderBoardMapper {
    int deleteByPrimaryKey(String id);

    int insert(LeaderBoard record);

    int insertSelective(LeaderBoard record);

    LeaderBoard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LeaderBoard record);

    int updateByPrimaryKey(LeaderBoard record);

    List<LeaderBoard> selectByTurnPage(int start, int limit);

    List<String> getNovelIds();

    List<LeaderBoard> getAllLeaderBoards();
}