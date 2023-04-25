package com.example.mojocebe.service;

import com.example.mojocebe.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {

   User login(String username,String password);
   void register(String username, String password, Integer roles);
   User find(String username);
}
