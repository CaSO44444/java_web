package com.example.mojocebe.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Follow {
    private int id;
    private String type;
    private int title;
    private Patient patient;
    private Doctor doctor;
    private Date follow_date;

    private Date next_follow;
    private int status;
}
