package com.example.mojocebe.entity;

import lombok.Data;

@Data
public class Admin {
    private int id;
    private String username;
    private String password;
    private int status;
    private int roles;
}

