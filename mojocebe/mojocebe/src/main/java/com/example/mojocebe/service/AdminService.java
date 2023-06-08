package com.example.mojocebe.service;

import com.example.mojocebe.Dto.AdminDto;
import com.example.mojocebe.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<Admin> getAllAdmins();
    void createAdmin(AdminDto adminDto);
    void updateAdmin(AdminDto adminDto);
    void deleteAdmin(int id);
}