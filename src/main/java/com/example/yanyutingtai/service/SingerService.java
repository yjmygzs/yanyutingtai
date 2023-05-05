package com.example.yanyutingtai.service;
import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.Singer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SingerService {
    //查询所有用户(带模糊查询)
    List<Singer> allSinger(int startIndex , int pageSize, Object searchValue);
    //查询用户总数量
    int countSinger();
    //根据ID删除
    boolean deleteById(int id);
    //添加歌手
    boolean addSinger(Singer singer);
    //根据ID查询歌手信息
    Singer getSingerById(int id);
    //更新歌手信息
    boolean updateSinger(Singer singer);
    //根据性别统计歌手数量
    List<GenderCount> countSingerGender();
    //查询所有歌手
    List<Singer> allSinger2();
    //根据性别查询歌手
    List<Singer> getSingerByGender(String gender);
}