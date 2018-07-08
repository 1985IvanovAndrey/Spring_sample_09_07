package com.mvcTest.service.impl;

import com.mvcTest.dao.UserDao;
import com.mvcTest.entity.User;
import com.mvcTest.service.UserService;
import org.omg.PortableServer.RequestProcessingPolicyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private Connection connection;

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public void addUser(String name, String secName, String phone) {
        String script = "INSERT INTO notebook(name,sec_name,phone) VALUES (" + "'" + name + "','" + secName + "','" + phone + "')";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(script);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delUser(int id) {
        String script = "DELETE FROM notebook WHERE id="+id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(script);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void editUserById(int id,String name,String secName,String phone){
        String script="UPDATE notebook SET name="+"'"+name+"',"+"sec_name="+"'"+secName+"',"+"phone="+"'"+phone+"' "+"WHERE id="+id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(script);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
