package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.service.MedicineListService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine-list")
public class MedicineListController {

    private final MedicineListService medicineListService;

    @Autowired
    public MedicineListController(MedicineListService medicineListService) {
        this.medicineListService = medicineListService;
    }
    @PostMapping("/getByPid")
    public Result<?> getByPid(@RequestParam int patient_id) {
        // 调用 Service 层的方法进行查询
        MedicineListDto medicineListDto = medicineListService.getByPid(patient_id);

        if (medicineListDto != null) {
            // 查询成功，返回查询结果
            return new Result<>().ok(medicineListDto);
        } else {
            // 查询结果为空
            return new Result<>().error("无信息");
        }
    }
    @PostMapping("/getByDid")
    public Result<?> getByDid(@RequestParam int doctor_id) {
        // 调用 Service 层的方法进行查询
        MedicineListDto medicineListDto = medicineListService.getByDid(doctor_id);

        if (medicineListDto != null) {
            // 查询成功，返回查询结果
            return new Result<>().ok(medicineListDto);
        } else {
            // 查询结果为空
            return new Result<>().error("无信息");
        }
    }
    @PostMapping("/add")
    public Result add(@RequestBody MedicineListDto medicinelistDto){
        this.medicineListService.add(medicinelistDto);
        return new Result().ok();
    }


}
