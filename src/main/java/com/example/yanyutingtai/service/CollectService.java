package com.example.yanyutingtai.service;

import com.example.yanyutingtai.domain.Collect;

import java.util.List;

public interface CollectService {
    //根据用户ID获取收藏列表
    List<Collect> getCollectById(int user_id);
    //添加收藏
    boolean addCollect(Collect collect);
    //取消收藏
    boolean deleteCollect(int user_id,int song_id);
    //判断收藏状态
    Boolean isCollect(Collect collect);
}
