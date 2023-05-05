package com.example.yanyutingtai.service.impl;

import com.example.yanyutingtai.dao.AdminMapper;
import com.example.yanyutingtai.domain.AdminUser;
import com.example.yanyutingtai.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public AdminUser adminLogin(AdminUser adminUser) {
        return adminMapper.AdminLogin(adminUser.getUsername());
    }
}
