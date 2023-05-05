package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.SongList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SonglistMapper {
    //分页查询(模糊查询)
    List<SongList> allSongList(@Param("startIndex") int startIndex,
                               @Param("pageSize") int pageSize,
                               @Param("searchValue") Object searchValue);
    //查询总数
    int countSongList();
    //删除指定歌单
    int deleteById(int id);
    //添加歌单
    int addSongList(SongList songlist);
    //根据ID查询歌单信息
    SongList getSongListById(int id);
    //更新歌单信息
    int updateSongList(SongList songList);
    //查询所有歌单
    List<SongList> allSongList2();
    //前台用户模糊搜索
    List<SongList> allSongList3(Object searchValue);
}
