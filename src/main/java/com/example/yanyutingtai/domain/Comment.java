package com.example.yanyutingtai.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int id;
    private int userId;
    private int songId;
    private int songListId;
    private String content;
    private int nowType;
    private Date create_time;
}
