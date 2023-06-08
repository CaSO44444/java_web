package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Patient;
import com.example.mojocebe.entity.Reservation;

import java.util.List;

public interface PatientMapper {
    List<Patient> queryall();
    List<Patient> queryById(Integer patient_id);
    void add(Patient patient);
    void edit(Patient patient);
    Patient find(Integer id);

    void BatchRemove(Integer[] ids);
    void editbyid(Integer patientID, Integer doctorID);

    void delete(Integer id);
    void registerAdd(String name, String tel, String id_card);


}
