package com.example.mojocebe.service;

import com.example.mojocebe.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> queryalldoctor();

    void registerAdd(Integer id, String name, String dept_name);
}
