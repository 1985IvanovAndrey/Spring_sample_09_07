package com.mvcTest.controller;

import com.mvcTest.checkData.CheckNumber;
import com.mvcTest.dao.UserDao;
import com.mvcTest.entity.User;
import com.mvcTest.service.UserService;
import com.mvcTest.service.impl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private UserService userService;

    private String errorMessage = null;

    List<User> userListModify = null;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudentList(Model model, HttpServletRequest req, HttpServletResponse resp) {
        model.addAttribute("userList", userService.userList());
        model.addAttribute("errorPhone", errorMessage);
        return "start";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String addUser(Model model) {
        return "edit";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String addUserInNotebook(Model model, HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String secName = req.getParameter("secName");
        String phone = req.getParameter("phone");
        if (CheckNumber.checkPhone(phone) == 0) {
            if (req.getParameter("buttonAdd") != null && req.getParameter("buttonAdd").equals("addUser")) {
                userService.addUser(name, secName, phone);
            }
        } else {
            errorMessage = "Номер введён НЕверно!!!!!";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public String delUserById(Model model, HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("buttonDel") != null && req.getParameter("buttonDel").equals("delUserById")) {
            int id = Integer.parseInt(req.getParameter("id"));
            userService.delUser(id);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/editById", method = RequestMethod.GET)
    public String editById(Model model) {
        return "editUserById";
    }

    @RequestMapping(value = "/editUserById", method = RequestMethod.GET)
    public String editUserById(Model model, HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String secName = req.getParameter("secName");
        String phonex = req.getParameter("phonex");
        int id = Integer.parseInt(req.getParameter("id"));
        if (CheckNumber.checkPhone(phonex) == 0) {
            if (req.getParameter("buttonEditById") != null && req.getParameter("buttonEditById").equals("editUser")) {
                userService.editUserById(id, name, secName, phonex);
            }
        }
        else {
            errorMessage = "Номер введён НЕверно!";
        }
        return "redirect:/";
    }
}