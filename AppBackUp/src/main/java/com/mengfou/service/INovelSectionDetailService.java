package com.mengfou.service;

import com.mengfou.entity.LbNovelSectionDetail;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/06 9:52
 */
public interface INovelSectionDetailService {
    LbNovelSectionDetail selectByNovelIdAndSectionId(String bid, int sid);
    List<String> getVaildNovelIds();
    int getNovelSectionNumber(String bid);
    List<String> getVaildNovelsCategory();

    List<String> getVaildNovelsCategoryDetail(String category);
}
