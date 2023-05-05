package com.example.yanyutingtai.service;

import com.example.yanyutingtai.domain.Song;
import com.example.yanyutingtai.domain.SongList;

import java.util.List;

public interface SongService {
    //根据歌手ID查询歌曲信息
    List<Song> getSongBySingerId(int startIndex , int pageSize, int SingerId);
    //根据歌单ID查询歌曲信息
    List<Song> getSongBySongListId(int startIndex , int pageSize, int SongListId);
    //查询对应歌手ID歌曲总数
    int countSong(int SingerId);
    //根据歌曲ID删除对应歌曲
    boolean deleteSongById(int id);
    //统计歌曲总数
    int countSongTotal();
    //添加歌曲
    boolean addSong(Song song);
    //根据歌曲ID查询歌曲
    List<Song> getSongById(int SongId);
    //根据歌手ID查询歌曲列表
    List<Song> getSongBySingerId2(int singer_id);
    //前台用户模糊查询
    List<Song> allSong1(Object searchValue);
}
