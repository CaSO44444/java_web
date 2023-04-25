package com.example.mojocebe.service;

import com.example.mojocebe.Dto.ReservationDto;
import com.example.mojocebe.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> queryall();
    void add(ReservationDto reservationDto);
    void delete(Integer id);
    void BatchRemove(Integer[] integers);

     Reservation getById(Integer integer);

     void update(ReservationDto reservationDto);
}
