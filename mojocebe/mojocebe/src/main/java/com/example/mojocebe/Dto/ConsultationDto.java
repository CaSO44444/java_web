package com.example.mojocebe.Dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ConsultationDto {
    private int consultation_id;
    private String type;
    private int con_num;
    private int patientId;
    private int deptId;
    private int bed_num;
    private int doctorId;
    private Float money;
    private Date time;
    private int  medicineId;
    private int pay;
    private int status;
}

