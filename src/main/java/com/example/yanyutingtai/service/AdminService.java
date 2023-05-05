package com.example.yanyutingtai.service;

import com.example.yanyutingtai.domain.AdminUser;

public interface AdminService {
    //管理员登录验证
    AdminUser adminLogin(AdminUser adminUser);
}
