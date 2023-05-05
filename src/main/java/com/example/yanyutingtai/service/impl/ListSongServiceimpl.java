package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.ListSongMapper;
import com.example.yanyutingtai.domain.ListSong;
import com.example.yanyutingtai.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceimpl implements ListSongService {
    @Autowired
    ListSongMapper listSongMapper;
    @Override
    public List<ListSong> getListSongById(int song_list_id){
        return listSongMapper.getListSongById(song_list_id);
    }
}
