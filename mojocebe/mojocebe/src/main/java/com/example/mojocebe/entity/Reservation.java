package com.example.mojocebe.entity;

import lombok.Data;

@Data
public class Reservation {
    private Integer id;
    private Doctor doctor;
    private Dept dept;
    private Title title;

    private int day;
    private Integer size;
    private Integer status;
}
