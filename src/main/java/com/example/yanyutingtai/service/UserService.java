package com.example.yanyutingtai.service;
import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.User;
import java.util.List;


public interface UserService {
    //查询所有用户(带模糊查询)
    List<User> allUser(int startIndex , int pageSize,Object searchValue);
    //查询用户总数量
    int countUser();
    //根据ID删除
    boolean deleteById(int id);
    //根据性别统计用户数量
    List<GenderCount> countUserGender();
    //用户登陆
    User userLogin(User user);
    //前台根据ID获取用户信息
    User userInfo(int id);
    //前台更新用户信息
    boolean updateUser(User user);
    //前台更新用户密码
    boolean updateUserPassword(User user);
    //前天用户注册
    boolean addUser(User user);
}
