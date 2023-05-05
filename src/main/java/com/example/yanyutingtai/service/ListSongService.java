package com.example.yanyutingtai.service;

import com.example.yanyutingtai.domain.ListSong;

import java.util.List;

public interface ListSongService {
    //根据歌单ID查询歌曲列表
    List<ListSong> getListSongById(int song_list_id);
}
