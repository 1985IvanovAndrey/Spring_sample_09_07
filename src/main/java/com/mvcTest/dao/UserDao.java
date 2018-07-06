package com.mvcTest.dao;

import com.mvcTest.entity.User;

import java.util.List;

public interface UserDao {

    List<User> userList();

    User getById();

}
