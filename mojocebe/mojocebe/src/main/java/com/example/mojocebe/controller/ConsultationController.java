package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.Consultation;
import com.example.mojocebe.service.ConsultationService;
import com.example.mojocebe.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @GetMapping("/consultation/queryall")
    public Result queryall(){
        List<Consultation> queryall = consultationService.queryall();
        return new Result().ok(queryall);
    }

    @PostMapping("/consultation/selectBydoctorId")
    public Result selectBydoctorId(@RequestParam String id, @RequestParam String status){
        Integer doctor_id = Integer.parseInt(id);
        Integer status_code = Integer.parseInt(status);
        List<Consultation> selectBydoctorId = consultationService.selectBydoctorId(doctor_id, status_code);
        return new Result().ok(selectBydoctorId);
    }

    @PostMapping("/consultation/selectBydate")
    public Result selectBytime(@RequestParam Date date, String docker_id, String status){
        List<Consultation> selectBytime = consultationService.selectBydate(date, docker_id, status);
        return new Result().ok(selectBytime);
    }

    @PostMapping("/consultation/selectByPatientName")
    public Result selectByPatientName(@RequestParam String patient_name){
        List<Consultation> selectByPatientName = consultationService.selectByPatientName(patient_name);
        return new Result().ok(selectByPatientName);
    }
    @PostMapping("/consultation/add")
    public Result add(@RequestBody ConsultationDto consultationDto){
        this.consultationService.add(consultationDto);
        return new Result().ok();
    }

    @GetMapping("/consultation/deleteById")
    public Result deleteById(Integer id){
        return new Result().ok();
    }

    @GetMapping("/consultation/batchRemove")
    public Result batchRemove(Integer[] ids){
        return new Result().ok();
    }

    @PostMapping("/consultation/update")
    public Result update(@RequestBody ConsultationDto consultationDto){
        this.consultationService.update(consultationDto);
        return new Result().ok();
    }
    @PostMapping("/consultation/update_status")
    public Result update_status(@RequestBody ConsultationDto consultationDto){
        this.consultationService.update_status(consultationDto);
        return new Result().ok();
    }



}
