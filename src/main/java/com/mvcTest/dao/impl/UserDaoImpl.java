package com.mvcTest.dao.impl;

import com.mvcTest.config.ConnectConfig;
import com.mvcTest.dao.UserDao;
import com.mvcTest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

//    @Autowired
//    private ConnectConfig connectConfig;

    @Autowired
    private Connection  connection;

//    @PostConstruct
//    public void init(){
//        connection = connectConfig.createConnection();
//    }

    @Override
    public List<User> userList() {

        final String QUERY_SQL = "SELECT * FROM student";

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<User> userList = new ArrayList<>();
        try {
            ps = connection.prepareStatement(QUERY_SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString(1));
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return userList;
    }

    @Override
    public User getById() {
        return null;
    }
}
