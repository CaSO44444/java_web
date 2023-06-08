package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Admin;

import java.util.List;

public interface AdminMapper {
    List<Admin> getAllAdmins();
    void createAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(Integer id);
}