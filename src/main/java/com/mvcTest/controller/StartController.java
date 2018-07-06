package com.mvcTest.controller;

import com.mvcTest.dao.UserDao;
import com.mvcTest.entity.User;
import com.mvcTest.service.UserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private UserService userService;


    List<User> userListModify = null;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudentList(Model model) {
        model.addAttribute("userList", userService.userList());
        model.addAttribute("userListModify", userListModify);
        return "start";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String getModifyStudentList(Model model) {
        userListModify = userService.userListWithModific();
        return "redirect:/";
    }

    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public String getStudentSalary(Model model) {
        System.out.println(" in salary contr");
        userService.userListWithCel().forEach((k, v) -> System.out.println(k.getName() + " -- " + v));
        return "redirect:/";
    }
}
