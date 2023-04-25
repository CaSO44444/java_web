package com.example.mojocebe.Dto;

import lombok.Data;

@Data
public class ReservationDto {
    private String doctorName;
    private Integer deptId;
    private Integer titleId;
    private Integer day;
    private Integer size;
}
