package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.ReservationDto;
import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.entity.Reservation;
import com.example.mojocebe.entity.Title;
import com.example.mojocebe.mapper.ReservationMapper;
import com.example.mojocebe.service.ReservationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Override
    public List<Reservation> queryall() {
        List<Reservation> queryall = reservationMapper.queryall();

        return queryall;
    }

    @Override
    public void add(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto,reservation);
        reservation.setStatus(0);

        Dept dept = new Dept();
        dept.setDept_id(reservationDto.getDeptId());
        reservation.setDept(dept);

        Title title = new Title();
        title.setTitle_id(reservationDto.getTitleId());
        reservation.setTitle(title);

        System.out.println(reservation);
        reservationMapper.add(reservation);

    }

    @Override
    public void delete(Integer id) {
        reservationMapper.delete(id);
    }

    @Override
    public void BatchRemove(Integer[] ids) {

        reservationMapper.BatchRemove(ids);
    }

    @Override
    public Reservation getById(Integer id) {
        Reservation reservation = reservationMapper.getById(id);
        return reservation;
    }

    @Override
    public void update(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto,reservation);
        reservation.setStatus(0);
        Dept dept = new Dept();
        dept.setDept_id(reservationDto.getDeptId());
        reservation.setDept(dept);
        Title title = new Title();
        title.setTitle_id(reservationDto.getTitleId());
        reservation.setTitle(title);
        System.out.println(reservation);
        Reservation update = reservationMapper.update(reservation);
    }


}
