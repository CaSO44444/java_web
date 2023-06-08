package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.AdminDto;
import com.example.mojocebe.entity.Admin;
import com.example.mojocebe.entity.Medicine;
import com.example.mojocebe.service.AdminService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAll")
    public Result getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new Result().ok(admins);
    }

    @PostMapping("/create")
    public Result createAdmin(@RequestBody AdminDto adminDto) {
        adminService.createAdmin(adminDto);
        return new Result().ok("Admin created successfully");
    }

//    @PutMapping("/update")
    @PostMapping("/update")
    public Result updateAdmin(@RequestBody AdminDto adminDto) {
        adminService.updateAdmin(adminDto);
        return new Result().ok("Admin updated successfully");
    }

//    @DeleteMapping("/delete")
    @PostMapping("/delete")
    public Result<String> deleteAdmin(@RequestParam Integer id) {
        adminService.deleteAdmin(id);
        return new Result().ok("Admin deleted successfully");
    }
}






