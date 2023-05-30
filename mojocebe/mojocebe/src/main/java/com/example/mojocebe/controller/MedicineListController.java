package com.example.mojocebe.controller;

import com.example.mojocebe.entity.MedicineList;
import com.example.mojocebe.service.MedicineListService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
