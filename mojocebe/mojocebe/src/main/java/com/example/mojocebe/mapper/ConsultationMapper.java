package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Consultation;

import java.sql.Date;
import java.util.List;

public interface ConsultationMapper {
    List<Consultation> queryall();

    List<Consultation> selectBydoctorId(Integer docker_id, Integer status);

    List<Consultation> selectBydate(Date time, String docker_id, String status);

    List<Consultation> selectByPatientName(String patient_name);
    void add(Consultation consultation);


    void deleteById(Integer id);

    void batchRemove(Integer[] ids);
}
