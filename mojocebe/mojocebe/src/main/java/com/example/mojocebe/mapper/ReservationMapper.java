package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Reservation;

import java.util.List;
import java.util.ListResourceBundle;

public interface ReservationMapper {
    List<Reservation> queryall();
    void add(Reservation reservation);
    void delete(Integer id);

    void BatchRemove(Integer[] ids);

    Reservation getById(Integer id);


    Reservation update(Reservation reservation);
}
