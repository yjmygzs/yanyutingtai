package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.SingerMapper;
import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.Singer;
import com.example.yanyutingtai.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SingerServiceimpl implements SingerService {
    @Autowired
    SingerMapper singerMapper;
    @Override
    public List<Singer> allSinger(int startIndex, int pageSize, Object searchValue){
        return singerMapper.allSinger(startIndex,pageSize,searchValue);
    }
    @Override
    public int countSinger() {
        return singerMapper.countSinger();
    }
    @Override
    public boolean deleteById(int id) {
        return singerMapper.deleteById(id)>0;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addSinger(Singer singer){
        return singerMapper.addSinger(singer)>0;
    }
    @Override
    public Singer getSingerById(int id){
        return singerMapper.getSingerById(id);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSinger(Singer singer){
        return singerMapper.updateSinger(singer)>0;
    }
    @Override
    public List<GenderCount> countSingerGender() {
        return singerMapper.countSingerGender();
    }
    @Override
    public List<Singer> allSinger2(){
        return singerMapper.allSinger2();
    }
    @Override
    public List<Singer> getSingerByGender(String gender){
        return singerMapper.getSingerByGender(gender);
    }
}