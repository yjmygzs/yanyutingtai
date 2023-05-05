package com.example.yanyutingtai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Singer {
    private int id;
    private String name;
    private String sex;
    private String pic;
    private Date birth;
    private String location;
    private String introduction;
}
