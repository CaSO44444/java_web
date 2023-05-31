package com.example.mojocebe.Dto;

import lombok.Data;

@Data
public class MedicineListDto {
    private int id;
    private int patient_id;
    private int doctor_id;
    private int medicine_id;
}