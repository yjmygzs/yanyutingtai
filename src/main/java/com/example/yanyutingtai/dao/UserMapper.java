package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.GenderCount;
import com.example.yanyutingtai.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //分页查询(模糊查询)
    List<User> allUser(@Param("startIndex") int startIndex,
                       @Param("pageSize") int pageSize,
                       @Param("searchValue") Object searchValue);
    //查询总数
    int countUser();
    //删除指定用户
    int deleteById(int id);
    //根据性别统计用户数量
    List<GenderCount> countUserGender();
    //用户前台登陆
    User userLogin(String username);
    //前台根据ID获取用户信息
    User userInfo(int id);
    //前台更新用户信息
    int updateUser(User user);
    //前台更新用户密码
    int updateUserPassword(User user);
    //前台用户注册
    int addUser(User user);
}
