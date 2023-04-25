package com.example.mojocebe.Dto;

import cn.hutool.core.date.DateTime;
import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.entity.Manager;
import lombok.Data;

import java.sql.Time;

@Data
public class VendorDto {

    private String type;
    private String vendor_name;
    private String level;
    private int num;
    private String province;
    private String address;
    private int managerId;
    private int doctorId;

}
