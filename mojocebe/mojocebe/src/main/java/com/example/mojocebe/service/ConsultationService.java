package com.example.mojocebe.service;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.Consultation;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

public interface ConsultationService {
    List<Consultation> queryall();

    List<Consultation> selectBydoctorId(Integer docker_id, Integer status);

    List<Consultation> selectBydate(Date time,String docker_id, String status);

    List<Consultation> selectByPatientName(String patient_name);
    void add(ConsultationDto consultationDto);
    void delete(Integer id);

    void batchDelete(Integer[] ids);

    void update(ConsultationDto consultationDto);

    void update_status(ConsultationDto consultationDto);
}
