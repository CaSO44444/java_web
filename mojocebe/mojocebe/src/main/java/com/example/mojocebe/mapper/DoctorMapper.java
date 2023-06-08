package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.entity.Doctor;

import java.util.List;

public interface DoctorMapper {
    List<Doctor> queryalldoctor();

    void registerAdd(String name, String dept_name);
}
