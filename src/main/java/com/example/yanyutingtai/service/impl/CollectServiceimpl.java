package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.CollectMapper;
import com.example.yanyutingtai.domain.Collect;
import com.example.yanyutingtai.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceimpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    @Override
    public List<Collect> getCollectById(int user_id){
        return collectMapper.getCollectById(user_id);
    }
    @Override
    public boolean addCollect(Collect collect){
        return collectMapper.addCollect(collect)>0;
    }
    @Override
    public boolean deleteCollect(int user_id,int song_id){
        return collectMapper.deleteCollect(user_id, song_id)>0;
    }
    @Override
    public Boolean isCollect(Collect collect){
        return collectMapper.isCollect(collect);
    }
}
