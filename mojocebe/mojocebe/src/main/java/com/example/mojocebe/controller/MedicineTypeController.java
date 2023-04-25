package com.example.mojocebe.controller;


import com.example.mojocebe.entity.MedicineType;
import com.example.mojocebe.service.MedicineTypeService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineTypeController {
    @Autowired
    private MedicineTypeService medicineTypeService;

    @GetMapping("/medicinetype/query")
    public Result query(){
        List<MedicineType> query = this.medicineTypeService.query();
        return new Result().ok(query);
    }


}
