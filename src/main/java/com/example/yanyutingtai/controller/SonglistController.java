package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.SongList;
import com.example.yanyutingtai.service.SonglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("songlist")
public class SonglistController {
    @Autowired
    SonglistService songlistService;
    @GetMapping
    public BaseResult allSonglist(@RequestParam("pageIndex")int pageIndex,
                              @RequestParam("pageSize")int pageSize,
                              @RequestParam("searchValue") Object searchValue){
        List<SongList> songList = songlistService.allSonglist((pageIndex-1) * pageSize,
                                    pageSize,searchValue);
        int count = songlistService.countSongList();
        Map<String,Object> map = new HashMap<>();
        map.put("songlist",songList);
        map.put("songlistcount",count);
        return BaseResult.success(map);
    }
    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable int id) {
        songlistService.deleteById(id);
        return BaseResult.success("删除成功");
    }
    @PostMapping
    public BaseResult addSongList(@RequestBody SongList songList){
        boolean result = songlistService.addSongList(songList);
        if(result){
            return BaseResult.success("添加成功！");
        }else {
            return BaseResult.fail("添加失败！");
        }
    }
    @GetMapping("/{id}")
    public BaseResult getSongListById(@PathVariable int id){
        SongList songList = songlistService.getSongListById(id);
        return BaseResult.success(songList);
    }
    @PutMapping
    public BaseResult updateSongList(@RequestBody SongList songList){
        boolean result = songlistService.updateSongList(songList);
        if(result){
            return BaseResult.success("更新成功！");
        }else {
            return BaseResult.fail("更新失败！");
        }
    }
    @GetMapping("/countSongList")
    public BaseResult countSongList(){
        return BaseResult.success(songlistService.countSongList());
    }
    @GetMapping("/allSongList2")
    public R allSongList2(){
        List<SongList> songLists = songlistService.allSongList2();
        return R.success("成功",songLists);
    }
    @GetMapping("/allSongList3/{keywords}")
    public R allSongList3(@PathVariable Object keywords){
        List<SongList> songLists = songlistService.allSongList3(keywords);
        return R.success("成功",songLists);
    }
}