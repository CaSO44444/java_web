package com.example.mojocebe.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Vendor {
    private int vendor_id;
    private String type;
    private String vendor_name;
    private String level;
    private int status;
    private int num;
    private String province;
    private String address;
    private Manager manager;
    private Doctor doctor;

}
