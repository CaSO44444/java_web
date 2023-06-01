package com.example.mojocebe.service;

import com.example.mojocebe.Dto.FollowDto;
import com.example.mojocebe.entity.Follow;
import com.example.mojocebe.entity.Patient;

import java.util.List;

public interface FollowService {
    List<Follow> queryall();

    void add(FollowDto followDto);

    void delete(Integer id);
    void BatchRemove(Integer[] integers);
    void edit(FollowDto followDto);
    Follow find(Integer id);



}
