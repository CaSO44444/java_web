package com.example.mojocebe.entity;

import lombok.Data;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

@Data
public class Medicine {
    private int Medicine_id;
    private MedicineType medicineType;
    private String Medicine_name;
    private String medicine_card;
    private String model;
    private Float price;
    private int medicine_num;
    private String unit;
    private Manager manager;
    private Vendor vendor;
    private int status;

}
