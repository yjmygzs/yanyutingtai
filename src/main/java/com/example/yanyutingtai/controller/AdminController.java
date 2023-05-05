package com.example.yanyutingtai.controller;

import com.example.yanyutingtai.Utils.HutoolJWTUtil;
import com.example.yanyutingtai.base.BaseResult;
import com.example.yanyutingtai.domain.AdminUser;
import com.example.yanyutingtai.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("adminlogin")
    public BaseResult login(@RequestBody AdminUser adminUser,
                            HttpServletRequest request) {
        AdminUser adminUser1 = adminService.adminLogin(adminUser);
        if (adminUser1 == null) {
            return BaseResult.fail("账号不存在！");
        } else if (!adminUser1.getPassword().equals(adminUser.getPassword())) {
            return BaseResult.fail("密码错误！");
        } else {
            //生成token
            String token = HutoolJWTUtil.createToken(adminUser);
            request.getServletContext().setAttribute("token", token);
            return BaseResult.success("登陆成功！", token);
        }
    }
    //退出系统
    @GetMapping("logOut")
    public BaseResult logout(HttpServletRequest request){
        request.getServletContext().removeAttribute("token");
        return BaseResult.success("退出成功");
    }
}
