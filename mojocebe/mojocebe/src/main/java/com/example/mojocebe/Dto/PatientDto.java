package com.example.mojocebe.Dto;

import com.example.mojocebe.entity.Doctor;
import lombok.Data;

@Data
public class PatientDto {
    private String name;
    private String gender;
    private int age;
    private String tel;
    private String id_card;
    private String address;
    private int doctor_id;
    private int follow;

}
