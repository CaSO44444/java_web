package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.Consultation;
import com.example.mojocebe.service.ConsultationService;
import com.example.mojocebe.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
