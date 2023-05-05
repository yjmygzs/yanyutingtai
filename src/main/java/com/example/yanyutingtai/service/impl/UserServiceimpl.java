package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.UserMapper;
import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.User;
import com.example.yanyutingtai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> allUser(int startIndex,int pageSize,Object searchValue){
        return userMapper.allUser(startIndex,pageSize,searchValue);
    }
    @Override
    public int countUser() {
        return userMapper.countUser();
    }
    @Override
    public boolean deleteById(int id) {
        return userMapper.deleteById(id)>0;
    }
    @Override
    public List<GenderCount> countUserGender() {
        return userMapper.countUserGender();
    }
    @Override
    public User userLogin(User user){
        return userMapper.userLogin(user.getUsername());
    }
    @Override
    public User userInfo(int id){
        return userMapper.userInfo(id);
    }
    @Override
    public boolean updateUser(User user){
        return userMapper.updateUser(user)>0;
    }
    @Override
    public boolean updateUserPassword(User user){
        return userMapper.updateUserPassword(user)>0;
    }
    @Override
    public boolean addUser(User user){
        return userMapper.addUser(user)>0;
    }
}
