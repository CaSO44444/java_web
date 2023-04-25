package com.example.mojocebe.controller;

import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.service.DoctorService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/doctor/query")
    public Result querydoctor(){
        List<Doctor> queryalldoctor = doctorService.queryalldoctor();

        return new Result().ok(queryalldoctor);
    }
}
