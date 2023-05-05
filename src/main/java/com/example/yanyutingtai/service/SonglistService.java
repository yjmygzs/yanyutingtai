package com.example.yanyutingtai.service;
import com.example.yanyutingtai.domain.SongList;
import java.util.List;

public interface SonglistService {
    //查询所有歌单(带模糊查询)
    List<SongList> allSonglist(int startIndex , int pageSize, Object searchValue);
    //查询歌单总数量
    int countSongList();
    //根据ID删除
    boolean deleteById(int id);
    //添加歌单
    boolean addSongList(SongList songList);
    //根据ID查询歌单信息
    SongList getSongListById(int id);
    //更新歌单信息
    boolean updateSongList(SongList songList);
    //查询所有歌单
    List<SongList> allSongList2();
    //前台用户模糊查询
    List<SongList> allSongList3(Object searchValue);
}
