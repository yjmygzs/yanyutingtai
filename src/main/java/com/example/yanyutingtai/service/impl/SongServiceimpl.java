package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.SongMapper;
import com.example.yanyutingtai.domain.Song;
import com.example.yanyutingtai.domain.SongList;
import com.example.yanyutingtai.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceimpl implements SongService {
    @Autowired
    SongMapper songMapper;
    //根据歌手ID查询对应歌曲信息
    public List<Song> getSongBySingerId(int startIndex,int pageSize,int SingerId){
        return songMapper.getSongBySingerId(startIndex,pageSize,SingerId);
    }
    //根据歌单ID查询其所包含的歌曲信息
    public List<Song> getSongBySongListId(int startIndex,int pageSize,int SongListId){
        return songMapper.getSongBySongListId(startIndex,pageSize,SongListId);
    }
    //对应歌手ID的歌曲总数
    public int countSong(int SingerId){
        return songMapper.countSong(SingerId);
    }
    //根据歌曲ID删除对应歌曲
    public boolean deleteSongById(int id){
        return songMapper.deleteSongById(id)>0;
    }
    //统计歌曲总数
    public int countSongTotal(){
        return songMapper.countSongTotal();
    }
    //添加歌曲
    public boolean addSong(Song song){
        return songMapper.addSong(song)>0;
    }
    //根据歌曲ID查询歌曲
    public List<Song> getSongById(int SongId){
        return songMapper.getSongById(SongId);
    }
    //根据歌手ID查询歌曲列表
    public List<Song> getSongBySingerId2(int singer_id){
        return songMapper.getSongBySingerId2(singer_id);
    }
    public List<Song> allSong1(Object searchValue){
        return songMapper.allSong1(searchValue);
    }
}
