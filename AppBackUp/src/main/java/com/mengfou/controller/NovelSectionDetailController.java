package com.mengfou.controller;

import com.mengfou.entity.LbNovelSectionDetail;
import com.mengfou.service.INovelSectionDetailService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/06 9:40
 */
@Controller
@RequestMapping("/book/")
public class NovelSectionDetailController {

    @Autowired
    INovelSectionDetailService iNovelSectionDetailService;

    @RequestMapping(value = "{bid}/section/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public LbNovelSectionDetail getNovelSectionDetail(
            @PathVariable("bid") String bid,
            @PathVariable("sid") int sid) {
        return iNovelSectionDetailService.selectByNovelIdAndSectionId(bid, sid);
    }

    @RequestMapping(value = "{id}/list")
    @ResponseBody
    public Pair<String, Integer> getNovelSectionNumber(@PathVariable("bid") String bid){
        int number = iNovelSectionDetailService.getNovelSectionNumber(bid);
        return new Pair<>(bid, number);
    }

    // 有效数据
    @RequestMapping(value = "vaild/list")
    @ResponseBody
    public List<String> getHasDetailNovels(){
        return iNovelSectionDetailService.getVaildNovelIds();
    }


    @RequestMapping(value = "vaild/category")
    @ResponseBody
    public List<String> getVaildNovelsCategory(){
        return iNovelSectionDetailService.getVaildNovelsCategory();
    }


    @RequestMapping(value = "vaild/category/{category}")
    @ResponseBody
    public List<String> getVaildNovelsCategoryDetail(@PathVariable("category") String category){
        return iNovelSectionDetailService.getVaildNovelsCategoryDetail(category);
    }

}
