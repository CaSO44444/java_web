package com.example.mojocebe.Dto;

import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.entity.Medicine;
import com.example.mojocebe.entity.Patient;
import lombok.Data;

import java.sql.Time;

@Data
public class ConsultationDto {
    private String type;
    private int con_num;
    private int patientId;
    private int deptId;
    private int bed_num;
    private int doctorId;
    private Float money;
    private Time time;
    private int  medicineId;
    private int pay;
}
