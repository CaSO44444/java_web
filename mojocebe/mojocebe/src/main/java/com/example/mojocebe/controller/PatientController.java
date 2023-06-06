package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.Dto.ReservationDto;
import com.example.mojocebe.entity.Patient;
import com.example.mojocebe.entity.Reservation;
import com.example.mojocebe.service.PatientService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping("/patient/query")
    public Result queryall() {
        List<Patient> queryall = patientService.queryall();
        if (queryall != null) {
            return new Result<>().ok(queryall);
        }
        return new Result().error("错误!");
    }

    @PostMapping("/patient/queryById")
    public Result queryById(@RequestParam String id) {
        Integer patient_id = Integer.parseInt(id);
        List<Patient> queryById = patientService.queryById(patient_id);
        if (queryById != null) {
            return new Result<>().ok(queryById);
        }
        return new Result().error("错误!");
    }
    @PostMapping("/patient/add")
    public Result add(@RequestBody PatientDto patientDto) {
        System.out.println(patientDto);
        patientService.add(patientDto);
        return new Result().ok();
    }


    @GetMapping("/patient/find")
    public Result find(Integer id){
        Patient patient= patientService.find(id);
        return new Result().ok(patient);
    }


    @PostMapping("/patient/edit")
    public Result edit(@RequestBody PatientDto patientDto){

        patientService.edit(patientDto);
        return new Result().ok();
    }

    @PostMapping("/patient/editById")
    public Result edit(@RequestParam String patient_ID, String doctor_ID){
        Integer patientID = Integer.parseInt(patient_ID);
        Integer doctorID = Integer.parseInt(doctor_ID);
        patientService.editbyid(patientID,doctorID);
        return new Result().ok();
    }


    @GetMapping("/patient/deleteById")
    public Result delete(Integer id) {

        patientService.delete(id);
        return new Result().ok();
    }

    //批量删除

    @GetMapping("/patient/batchRemove")
    public Result BatchRemove(Integer[] ids) {


        patientService.BatchRemove(ids);

        return new Result().ok();
    }

}
