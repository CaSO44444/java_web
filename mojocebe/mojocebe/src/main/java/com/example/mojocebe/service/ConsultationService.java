package com.example.mojocebe.service;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.Consultation;

import java.util.List;

public interface ConsultationService {
    List<Consultation> queryall();

    void add(ConsultationDto consultationDto);
    void delete(Integer id);

    void batchDelete(Integer[] ids);
}
