package com.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/users/*")
public class ValidationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        String name = req.getParameter("name");
        String surName = req.getParameter("sur_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        boolean chek = true;

        if (StringUtils.isEmpty(name)) {
            chek = false;
            errorMsg(resp, "Please, input your Name!");
        }
        if (StringUtils.isEmpty(surName)) {
            chek = false;
            errorMsg(resp, "Please, input your Last Name!");
        }
        if (StringUtils.isEmpty(login)) {
            chek = false;
            errorMsg(resp, "Please, input your Login!");
        }
        if (StringUtils.isEmpty(password)) {
            chek = false;
            errorMsg(resp, "Please, input your Password!");
        }
        if (!validationAge(age)) {
            chek = false;
            errorMsg(resp, "Please, input correct Age!");
        }

        if (StringUtils.isEmpty(phone)) {
            chek = false;
            errorMsg(resp, "Please, input your Phone!");
        }

        if (!validationEmail(email)) {
            chek = false;
            errorMsg(resp, "Please, input correct Email!");
        }

        if (StringUtils.isEmpty(address)) {
            chek = false;
            errorMsg(resp, "Please, input your Address!");
        }

        if (chek) {
            filterChain.doFilter(req, resp);
        }
    }


    boolean validationEmail(String email) throws IOException {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        String emailPattern = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    boolean validationAge(String age) throws IOException {
        if (StringUtils.isEmpty(age)) {
            return false;
        }
        String agePattern = "^(0?[1-9]|[1-9][0-9])$";
        Pattern pattern = Pattern.compile(agePattern);
        Matcher matcher = pattern.matcher(age);
        return matcher.matches();
    }

    private void errorMsg(ServletResponse resp, String msg) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(msg);
        writer.flush();
    }

    public void destroy() {

    }
}
