package com.example.yanyutingtai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongList {
    private int id;
    private String title;
    private String pic;
    private String introduction;
    private String style;
}
