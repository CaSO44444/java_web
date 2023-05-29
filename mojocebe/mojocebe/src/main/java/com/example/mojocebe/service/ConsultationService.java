package com.example.mojocebe.service;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.Consultation;

import java.sql.Date;
import java.util.List;

public interface ConsultationService {
    List<Consultation> queryall();

    List<Consultation> selectBydoctorId(Integer docker_id, Integer status);

    List<Consultation> selectBydate(Date time);

    List<Consultation> selectByPatientName(String patient_name);
    void add(ConsultationDto consultationDto);
    void delete(Integer id);

    void batchDelete(Integer[] ids);
}
