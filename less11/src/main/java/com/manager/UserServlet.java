package com.manager;

import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(1500);
            PrintWriter writer = resp.getWriter();
            List<User> users = Arrays.asList(new User("name1", 1), new User("name2", 2));
            writer.print(users);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
