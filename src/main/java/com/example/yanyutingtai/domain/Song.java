package com.example.yanyutingtai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private int id;
    private int singer_id;
    private String name;
    private String introduction;
    private String pic;
    private String lyric;
    private String url;
}
