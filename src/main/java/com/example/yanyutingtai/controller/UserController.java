package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.base.R;
import com.example.yanyutingtai.domain.User;
import com.example.yanyutingtai.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public BaseResult allUser(@RequestParam("pageIndex")int pageIndex,
                              @RequestParam("pageSize")int pageSize,
                              @RequestParam("searchValue") Object searchValue){
        List<User> userList = userService.allUser((pageIndex-1) * pageSize,pageSize,searchValue);
        int count = userService.countUser();
        Map<String,Object> map = new HashMap<>();
        map.put("list",userList);
        map.put("totalSize",count);
        return BaseResult.success(map);
    }
    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable int id) {
        userService.deleteById(id);
        return BaseResult.success("删除成功");
    }
    //统计用户总数
    @GetMapping("/countUser")
    public BaseResult countUser(){
        return BaseResult.success(userService.countUser());
    }
    //按照性别统计用户数量
    @GetMapping("/countUserGender")
    public BaseResult countSingerGender(){
        return BaseResult.success(userService.countUserGender());
    }
    //用户登陆
    @PostMapping("/userLogin")
    public R login(@RequestBody User user,
                   HttpSession session) {
        User user1 = userService.userLogin(user);
        if (user1 == null) {
            return R.error("账号不存在！");
        } else if (!user1.getPassword().equals(user.getPassword())) {
            return R.error("密码错误！");
        } else {
            //生成session
            session.setAttribute("username",user1.getUsername());
            List<User> user2 = new ArrayList<>();
            user2.add(user1);
            return R.success("登陆成功！",user2);
        }
    }
    //前台删除
    @GetMapping ("/userDelete/{id}")
    public R userdelete(@PathVariable int id) {
        boolean result = userService.deleteById(id);
        if(result){
            return R.success("删除成功");
        }else {
            return R.error("删除失败");
        }
    }
    //前台根据ID获取用户信息
    @GetMapping("/getUserInfo/{id}")
    public R userInfo(@PathVariable int id){
        User user = userService.userInfo(id);
        List<User> user2 = new ArrayList<>();
        user2.add(user);
        return R.success("成功",user2);
    }
    //前台更新用户信息
    @PostMapping("/updateUser")
    public R updateUser(@RequestBody User user){
        boolean result = userService.updateUser(user);
        if(result){
            return R.success("更新成功");
        }else {
            return R.error("更新失败");
        }
    }
    //前台更新用户密码
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody User user){
        boolean result = userService.updateUserPassword(user);
        if (result){
            return R.success("更新成功");
        }else {
            return R.error("更新失败");
        }
    }
    //前台用户注册
    @PostMapping("/addUser")
    public R addUser(@RequestBody User user){
        boolean result = userService.addUser(user);
        if (result){
            return R.success("注册成功");
        }else {
            return R.error("注册失败");
        }
    }
}