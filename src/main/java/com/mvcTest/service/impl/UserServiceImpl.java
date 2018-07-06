package com.mvcTest.service.impl;

import com.mvcTest.dao.UserDao;
import com.mvcTest.entity.User;
import com.mvcTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public List<User> userListWithModific() {
        List<User> userList = userDao.userList();
        for (User user : userList) {
            user.setName(user.getName() + " -word");
        }
        return userList;
    }

    @Override
    public Map<User, String> userListWithCel() {
        List<User> userList = userDao.userList();
        Map<User, String> userSelary = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            userSelary.put(userList.get(i), String.valueOf(i + 100));
        }
        return userSelary;
    }

    @Override
    public User getById() {
        return null;
    }
}
