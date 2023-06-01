package com.example.mojocebe.entity;

import lombok.Data;

import java.sql.Date;

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

    private Date time;
    private Medicine medicine;
    private int pay;
    private int status;

    public int getConsultation_id() {
        return consultation_id;
    }
}
