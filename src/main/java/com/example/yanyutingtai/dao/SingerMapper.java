package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.Singer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SingerMapper {
    //分页查询(模糊查询)
    List<Singer> allSinger(@Param("startIndex") int startIndex,
                           @Param("pageSize") int pageSize,
                           @Param("searchValue") Object searchValue);
    //查询总数
    int countSinger();
    //删除指定歌手
    int deleteById(int id);
    //添加歌手信息
    int addSinger(Singer singer);
    //根据ID查询歌手信息
    Singer getSingerById(int id);
    //更新用户信息
    int updateSinger(Singer singer);
    //根据性别统计歌手数量
    List<GenderCount> countSingerGender();
    //查询所有歌手
    List<Singer> allSinger2();
    //按性别查询歌手
    List<Singer> getSingerByGender(String gender);
}
