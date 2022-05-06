package com.mengfou.dao;

import com.mengfou.entity.LbNovelSectionDetail;
import com.mengfou.entity.LeaderBoard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LbNovelSectionDetailMapper {
    int deleteByPrimaryKey(Integer identityid);

    int insert(LbNovelSectionDetail record);

    int insertSelective(LbNovelSectionDetail record);

    LbNovelSectionDetail selectByPrimaryKey(Integer identityid);

    LbNovelSectionDetail selectByNovelIdAndSectionId(String bid, Integer sid);

    int updateByPrimaryKeySelective(LbNovelSectionDetail record);

    int updateByPrimaryKeyWithBLOBs(LbNovelSectionDetail record);

    int updateByPrimaryKey(LbNovelSectionDetail record);

    List<String> selectVaildNovelIdsInLbNovelSectionDetail();

    int getNovelSectionNumber(String bid);

    List<String> getVaildNovelsCategory();

    List<String> getVaildNovelsCategoryDetail(String category);
}