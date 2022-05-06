package com.mengfou.controller;

import com.mengfou.entity.LeaderBoard;
import com.mengfou.service.ILeaderBoradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 梦否
 * @date 2022/05/05 22:04
 */
@Controller
@RequestMapping("/book/")
public class LeaderBoradController {

    @Autowired
    ILeaderBoradService iLeaderBoradService;

    @RequestMapping(value = "list/{currentPage}", method = RequestMethod.GET)
    @ResponseBody
    public List<LeaderBoard> getLeaderBoradByPageTag(
            @PathVariable("currentPage") int currentPage,
            @RequestParam("limit") int limit) {
        return iLeaderBoradService.getLeaderBoardDatas(currentPage, limit);
    }

    @RequestMapping(value = "{bid}", method = RequestMethod.GET)
    @ResponseBody
    public LeaderBoard getLeaderBoradById(@PathVariable("bid") String bid){
        return iLeaderBoradService.getLeaderBoardById(bid);
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public List<String> getHasDetailNovels(){
        return iLeaderBoradService.getNovelIds();
    }
}
