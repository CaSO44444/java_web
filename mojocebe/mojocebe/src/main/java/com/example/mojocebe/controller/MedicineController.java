package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.entity.Medicine;
import com.example.mojocebe.service.MedicineService;
import com.example.mojocebe.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/medicine/queryall")
    public Result queryall(){
        List<Medicine> queryall = this.medicineService.queryall();
        return new Result().ok(queryall);
    }

    @GetMapping("/medicine/deleteById")
    public Result delete(Integer id) {

        medicineService.delete(id);
        return new Result().ok();
    }

    //批量删除

    @GetMapping("/medicine/batchRemove")
    public Result BatchRemove(Integer[] ids) {


        medicineService.batchDelete(ids);

        return new Result().ok();
    }

    @PostMapping("/medicine/add")
    public Result add(@RequestBody MedicineDto medicineDto){
        this.medicineService.add(medicineDto);
        return new Result().ok();
    }


    @GetMapping("/medicine/getById")
    public Result getById(Integer id){
        Medicine byId = this.medicineService.getById(id);
        return new Result().ok(byId);
    }

    @PostMapping("/medicine/edit")
    public Result edit(@RequestBody MedicineDto medicineDto){
        this.medicineService.edit(medicineDto);
        return new Result().ok();
    }
}
