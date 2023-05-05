package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.SonglistMapper;
import com.example.yanyutingtai.domain.SongList;
import com.example.yanyutingtai.service.SonglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SonglistServiceimpl implements SonglistService {
    @Autowired
    SonglistMapper songlistMapper;
    @Override
    public List<SongList> allSonglist(int startIndex, int pageSize, Object searchValue){
        return songlistMapper.allSongList(startIndex,pageSize,searchValue);
    }
    @Override
    public int countSongList() {
        return songlistMapper.countSongList();
    }
    @Override
    public boolean deleteById(int id) {
        return songlistMapper.deleteById(id)>0;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addSongList(SongList songList){
        return songlistMapper.addSongList(songList)>0;
    }
    @Override
    public SongList getSongListById(int id){
        return songlistMapper.getSongListById(id);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSongList(SongList songList){
        return songlistMapper.updateSongList(songList)>0;
    }
    @Override
    public List<SongList> allSongList2(){
        return songlistMapper.allSongList2();
    }
    @Override
    public List<SongList> allSongList3(Object searchValue){
        return songlistMapper.allSongList3(searchValue);
    }
}