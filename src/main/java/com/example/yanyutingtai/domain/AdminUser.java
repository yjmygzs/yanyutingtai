package com.example.yanyutingtai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {
    private int id;
    private String username;
    private String password;
}
