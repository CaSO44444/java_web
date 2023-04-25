package com.example.mojocebe.controller;

import com.example.mojocebe.Dto.ReservationDto;
import com.example.mojocebe.entity.Reservation;
import com.example.mojocebe.service.ReservationService;
import com.example.mojocebe.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation/query")
    public Result queryall() {
        List<Reservation> queryall = reservationService.queryall();
        if (queryall != null) {
            return new Result<>().ok(queryall);
        }
        return new Result().error("错误！");
    }

    @PostMapping("/reservation/add")
    public Result add(@RequestBody ReservationDto reservationDto) {
        System.out.println(reservationDto);
        reservationService.add(reservationDto);
        return new Result().ok();
    }

    @GetMapping("/reservation/deleteById")
    public Result delete(Integer id) {

        reservationService.delete(id);
        return new Result().ok();
    }

    //批量删除

    @GetMapping("/reservation/batchRemove")
    public Result BatchRemove(Integer[] ids) {


        reservationService.BatchRemove(ids);

        return new Result().ok();
    }

    @GetMapping("/reservation/find")
    public Result getById(Integer id) {
        System.out.println(id);
        Reservation reservation = reservationService.getById(id);
        System.out.println(reservation);
        return new Result().ok(reservation);
    }


    @PostMapping("/reservaion/update")
    public Result update(@RequestBody ReservationDto reservationDto){
        reservationService.update(reservationDto);
        return new Result().ok();
    }

}