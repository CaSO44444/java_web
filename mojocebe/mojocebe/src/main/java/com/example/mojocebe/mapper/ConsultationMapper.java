package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Consultation;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ConsultationMapper {
    List<Consultation> queryall();

    void add(Consultation consultation);


    void deleteById(Integer id);

    void batchRemove(Integer[] ids);
}
