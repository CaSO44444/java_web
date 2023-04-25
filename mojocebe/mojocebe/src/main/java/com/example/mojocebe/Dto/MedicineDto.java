package com.example.mojocebe.Dto;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class MedicineDto {
    private int medicineTypeId;
    private String Medicine_name;
    private String medicine_card;
    private String model;
    private Float price;
    private int medicine_num;
    private String unit;
    private int managerId;
    private int vendorId;
}
