package com.example.mojocebe.Dto;

import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.entity.Patient;
import lombok.Data;

import java.util.Date;
@Data
public class FollowDto {
    private int id;
    private String type;
    private String title;
    private int patientId;
    private int doctorId;
    private Date follow_date;
    private Date next_follow;
    private int status;
}
