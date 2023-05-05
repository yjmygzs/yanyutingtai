package com.example.yanyutingtai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String introduction;
    private Date create_time;
    private String oldPassword;
}
