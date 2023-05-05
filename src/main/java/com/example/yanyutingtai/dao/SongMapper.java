package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.Song;
import com.example.yanyutingtai.domain.SongList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {
    //根据歌手ID查询对应歌曲列表(具有分页功能)
    List<Song> getSongBySingerId(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize,
                                 @Param("SingerId") int SingerId);
    //根据歌单ID查询对应歌曲列表(具有分页功能)
    List<Song> getSongBySongListId(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize,
                                 @Param("SongListId") int SongListId);
    //根据歌手ID查询对应的歌曲总数
    int countSong(int SingerId);
    //根据歌曲ID删除歌曲
    int deleteSongById(int id);
    //统计歌曲总数
    int countSongTotal();
    //添加歌曲
    int addSong(Song song);
    //根据歌曲ID查询歌曲
    List<Song> getSongById(int SongId);
    //根据歌手ID查询歌曲列表
    List<Song> getSongBySingerId2(int singer_id);
    //前台用户模糊搜索
    List<Song> allSong1(Object searchValue);
}
