package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.ListSong;
import com.example.yanyutingtai.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ListSong")
public class ListSongController {
    @Autowired
    ListSongService listSongService;
    @GetMapping("getSong1")
    public R getListSongById(int song_list_id){
        List<ListSong> listSongs = listSongService.getListSongById(song_list_id);
        return R.success("成功",listSongs);
    }
}
