package com.mvcTest.service;

import com.mvcTest.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> userList();

    List<User> userListWithModific();

    Map<User,String> userListWithCel();

    User getById();

}
