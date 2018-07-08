package com.mvcTest.service;

import com.mvcTest.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> userList();

    void addUser(String name,String secName,String phone);

    void delUser(int id);

    void editUserById(int id,String name,String secName,String phone);



}
