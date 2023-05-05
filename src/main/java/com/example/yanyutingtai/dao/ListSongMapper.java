package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongMapper {
    //根据歌单ID查询
    List<ListSong> getListSongById(int song_list_id);
}
