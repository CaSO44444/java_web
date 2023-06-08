package com.example.mojocebe.Dto;

import lombok.Data;

@Data
public class AdminDto {
    private int id;
    private String username;
    private String password;
    private int status;
    private int roles;
}

