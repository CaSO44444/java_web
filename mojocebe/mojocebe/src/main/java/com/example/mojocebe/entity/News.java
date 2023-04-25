package com.example.mojocebe.entity;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private String title;
    private String publisher;
    private Date pub_time;
    private String origin;
    private Integer times;
    private String file;
}
