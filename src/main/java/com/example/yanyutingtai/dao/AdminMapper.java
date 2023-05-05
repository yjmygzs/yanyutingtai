package com.example.yanyutingtai.dao;

import com.example.yanyutingtai.domain.AdminUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    AdminUser AdminLogin(String username);
}
