package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Follow;
import com.example.mojocebe.entity.Patient;

import java.util.List;

public interface FollowMapper{
    List<Follow> queryall();

    void add(Follow follow);

    void BatchRemove(Integer[] ids);


    void delete(Integer id);
    void edit(Follow follow);
    Follow find(Integer id);

}
