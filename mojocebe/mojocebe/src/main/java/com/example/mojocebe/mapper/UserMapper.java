package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User login(@Param("username") String username, @Param("password") String password);
    void register(@Param("username") String username, @Param("password") String password,  @Param("roles")Integer roles);
    User find(@Param("username") String username);
}
