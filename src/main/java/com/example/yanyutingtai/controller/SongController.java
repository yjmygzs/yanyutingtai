package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.Song;
import com.example.yanyutingtai.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("song")
public class SongController {
    @Autowired
    SongService songService;
    //根据歌手ID查询对应歌曲列表（有分页功能）
    @GetMapping
    public BaseResult getSongBySingerId(@RequestParam("pageIndex")int pageIndex,
                                        @RequestParam("pageSize")int pageSize,
                                        @RequestParam("singerid") int SingerId){
        List<Song> songList = songService.getSongBySingerId((pageIndex-1) * pageSize,
                                pageSize,SingerId);
        int count = songService.countSong(SingerId);
        Map<String,Object> map = new HashMap<>();
        map.put("songList",songList);
        map.put("songCount",count);
        return BaseResult.success(map);
    }
    //根据歌单ID查询歌曲（有分页功能）
    @GetMapping("/songListId")
    public BaseResult getSongBySongListId(@RequestParam("pageIndex")int pageIndex,
                                          @RequestParam("pageSize")int pageSize,
                                          @RequestParam("songlistId")int SongListId){
        List<Song> songList = songService.getSongBySongListId((pageIndex-1) * pageSize,
                                pageSize,SongListId);
        int count = songService.countSong(SongListId);
        Map<String,Object> map = new HashMap<>();
        map.put("songList",songList);
        map.put("songCount",count);
        return BaseResult.success(map);
    }
    //根据歌曲ID删除
    @DeleteMapping("/{id}")
    public BaseResult deleteSongById(@PathVariable int id){
        boolean result = songService.deleteSongById(id);
        if(result){
            return BaseResult.success("删除成功！");
        }else {
            return BaseResult.fail("删除失败！");
        }
    }
    //统计歌曲总数
    @GetMapping("/countSong")
    public BaseResult countSong(){
        return BaseResult.success(songService.countSongTotal());
    }
    //添加歌曲
    @PostMapping
    public BaseResult addSinger(@RequestBody Song song){
        boolean result = songService.addSong(song);
        if(result){
            return BaseResult.success("添加成功！");
        }else {
            return BaseResult.fail("添加失败！");
        }
    }
    //根据歌曲ID查询歌曲
    @GetMapping("/getSongById")
    public R getAllSong1(int SongId){
        List<Song> song = songService.getSongById(SongId);
        return R.success("成功",song);
    }
    //根据歌手ID查询歌曲列表
    @GetMapping("/getSongBySingerId2")
    public R getSongBySingerId2(int singer_id){
        List<Song> songs = songService.getSongBySingerId2(singer_id);
        return R.success("成功",songs);
    }
    //前台用户模糊查询
    @GetMapping("/allSong1/{keywords}")
    public R allSongList3(@PathVariable Object keywords){
        List<Song> songs = songService.allSong1(keywords);
        return R.success("成功",songs);
    }
}
