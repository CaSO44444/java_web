package com.example.mojocebe.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.sql.Time;

@Data
public class Consultation {
    private int consultation_id;
    private String type;
    private int con_num;
    private Patient patient;
    private Dept dept;
    private int bed_num;
    private Doctor doctor;
    private Float money;
    private Time time;
    private Medicine medicine;
    private int pay;
    private int status;

}
