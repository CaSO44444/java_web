package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.mapper.DoctorMapper;
import com.example.mojocebe.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> queryalldoctor() {
        List<Doctor> queryalldoctor = doctorMapper.queryalldoctor();
        return queryalldoctor;
    }

    @Override
    public void registerAdd(Integer id, String name, String dept_name){
        doctorMapper.registerAdd(id, name, dept_name);
    }
}
