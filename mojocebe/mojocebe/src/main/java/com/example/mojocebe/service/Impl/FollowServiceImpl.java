package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.FollowDto;
import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.entity.*;
import com.example.mojocebe.mapper.FollowMapper;
import com.example.mojocebe.service.FollowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;


    @Override
    public List<Follow> queryall() {
        List<Follow> queryall = followMapper.queryall();
        return queryall;
    }

    @Override
    public void add(FollowDto followDto) {
        Follow follow = new Follow();
        BeanUtils.copyProperties(followDto,follow);
        follow.setStatus(0);

        Patient patient = new Patient();
        patient.setId(followDto.getPatientId());
        follow.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(followDto.getDoctorId());
        follow.setDoctor(doctor);
        followMapper.add(follow);
    }

    @Override
    public void delete(Integer id) {
        followMapper.delete(id);
    }

    @Override
    public void BatchRemove(Integer[] integers) {
        followMapper.BatchRemove(integers);
    }

    @Override
    public void edit(FollowDto followDto) {
        Follow follow = new Follow();
        BeanUtils.copyProperties(followDto,follow);
        follow.setStatus(0);

        Patient patient = new Patient();
        patient.setId(followDto.getPatientId());
        follow.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(followDto.getDoctorId());
        follow.setDoctor(doctor);
        followMapper.edit(follow);
    }

    @Override
    public Follow find(String doctor_name) {
        Follow follow = followMapper.find(doctor_name);
        return follow;
    }
}
