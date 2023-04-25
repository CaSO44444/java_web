package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.VendorDto;
import com.example.mojocebe.entity.Vendor;
import com.example.mojocebe.service.VendorService;
import com.example.mojocebe.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/vendor/queryall")
    public Result queryall(){
        List<Vendor> queryall = vendorService.queryall();
        return new Result().ok(queryall);
    }


    @GetMapping("/vendor/getById")
    public Result getById(Integer id){
        Vendor vendor = this.vendorService.getById(id);
        return new Result().ok(vendor);
    }

    @PostMapping("/verdor/update")
    public Result update(@RequestBody VendorDto vendorDto){
        return new Result().ok();
    }

    @PostMapping("/vendor/add")
    public Result add(@RequestBody VendorDto vendorDto){
        System.out.println(vendorDto);
        this.vendorService.add(vendorDto);
        return new Result().ok();
    }

    @GetMapping("/vendor/deleteById")
    public Result deleteById(Integer id){
        this.vendorService.delete(id);
        return new Result().ok();
    }

    @GetMapping("/vendor/batchDelete")
    public Result batchDelete(Integer[] ids){
        this.vendorService.batchDelete(ids);
        return new Result().ok();
    }
}
