package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.Collect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {
    //查询指定用户ID的收藏列表
    List<Collect> getCollectById(int user_id);
    //前台用户添加
    int addCollect(Collect collect);
    //前台用户取消收藏
    int deleteCollect(int user_id,int song_id);
    //判断收藏状态
    Boolean isCollect(Collect collect);
}
