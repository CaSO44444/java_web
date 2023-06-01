package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.FollowDto;
import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.entity.Follow;
import com.example.mojocebe.entity.Patient;
import com.example.mojocebe.service.FollowService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/follow/query")
    public Result queryall(){
        List<Follow> queryall = followService.queryall();
        return new Result().ok(queryall);
    }

//    添加
    @PostMapping("/follow/add")
    public Result add(@RequestBody FollowDto followDto) {
        followService.add(followDto);
        return new Result().ok();
    }


    @GetMapping("/follow/deleteById")
    public Result delete(Integer id) {

        followService.delete(id);
        return new Result().ok();
    }

    //批量删除

    @GetMapping("/follow/batchRemove")
    public Result BatchRemove(Integer[] ids) {


        followService.BatchRemove(ids);

        return new Result().ok();
    }

    @PostMapping("/follow/find")
    public Result find(Integer id){
        List<Follow> follow= followService.find(id);
        return new Result().ok(follow);
    }


    @PostMapping("/follow/edit")
    public Result edit(@RequestBody FollowDto followDto){

        followService.edit(followDto);
        return new Result().ok();
    }

}
