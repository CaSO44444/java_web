package com.example.mojocebe.entity;

import lombok.Data;

@Data
public class Patient {
    private int id;
    private String name;
    private int gender;
    private int age;
    private String tel;
    private String id_card;
    private String address;
    private Doctor doctor;
    private int follow;
    private int status;
}
