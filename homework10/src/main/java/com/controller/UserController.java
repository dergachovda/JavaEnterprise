package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init() throws ServletException {
        AutowireCapableBeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surName = req.getParameter("sur_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        User user = new User(
                name,
                surName,
                login,
                password,
                Integer.valueOf(age),
                phone,
                email,
                address
        );

        List<User> users = userService.addUser(user);

        resp.getWriter().println(Arrays.toString(users.toArray()));

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userNamesList = userService.getAllUsers();
        resp.getWriter().print(userNamesList);
    }


}
