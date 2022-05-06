package com.mengfou.service.impl;

import com.mengfou.dao.LbNovelSectionDetailMapper;
import com.mengfou.entity.LbNovelSectionDetail;
import com.mengfou.service.INovelSectionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/06 9:52
 */
@Service("iNovelSectionDetailService")
public class NovelSectionDetailServiceImpl implements INovelSectionDetailService {
    @Autowired
    LbNovelSectionDetailMapper lbNovelSectionDetailMapper;


    @Override
    public LbNovelSectionDetail selectByNovelIdAndSectionId(String bid, int sid) {
        return lbNovelSectionDetailMapper.selectByNovelIdAndSectionId(bid, sid);
    }

    @Override
    public List<String> getVaildNovelIds() {
        return lbNovelSectionDetailMapper.selectVaildNovelIdsInLbNovelSectionDetail();
    }

    @Override
    public int getNovelSectionNumber(String bid) {
        return lbNovelSectionDetailMapper.getNovelSectionNumber(bid);
    }

    @Override
    public List<String> getVaildNovelsCategory() {
        return lbNovelSectionDetailMapper.getVaildNovelsCategory();
    }

    @Override
    public List<String> getVaildNovelsCategoryDetail(String category) {
        return lbNovelSectionDetailMapper.getVaildNovelsCategoryDetail(category);
    }
}
