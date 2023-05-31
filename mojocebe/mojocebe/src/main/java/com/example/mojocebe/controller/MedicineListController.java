package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.MedicineList;
import com.example.mojocebe.service.MedicineListService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineListController {
    @Autowired
    private MedicineListService medicineListService;

    @GetMapping("/medicine-list/query")
    public Result queryAll(){
        List<MedicineList> query = this.medicineListService.queryAll();
        return new Result().ok(query);
    }

    @PostMapping("/medicine-list/selectByPId")
    public Result selectByPId(@RequestParam Integer patient_id){
        List<MedicineList> selectByPId = this.medicineListService.selectByPId(patient_id);
        return new Result().ok(selectByPId);
    }

    @PostMapping("/medicine-list/selectByDId")
    public Result selectByDId(@RequestParam int doctor_id){
        List<MedicineList> selectByDId = this.medicineListService.selectByDId(doctor_id);
        return new Result().ok(selectByDId);
    }

    @PostMapping("/medicine-list/add")
    public Result add(@RequestBody MedicineListDto medicineListDto){
        this.medicineListService.add(medicineListDto);
        return new Result().ok();
    }

    @PostMapping("/medicine-list/deleteById")
    public Result deleteById(@RequestParam Integer id){
        this.medicineListService.deleteById(id);
        return new Result().ok();
    }
}
