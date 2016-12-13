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
    public static final String EMAIL_PATTERN = "[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))";

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

        if (StringUtils.isEmpty(name)) {
            errorMsg(resp, "Please, input your Name!");
        }
        if (StringUtils.isEmpty(surName)) {
            errorMsg(resp, "Please, input your Last Name!");
        }
        if (StringUtils.isEmpty(login)) {
            errorMsg(resp, "Please, input your Login!");
        }
        if (StringUtils.isEmpty(password)) {
            errorMsg(resp, "Please, input your Password!");
        }
        if (StringUtils.isEmpty(age)) {
            errorMsg(resp, "Please, input your Age!");
        }
        if (StringUtils.isEmpty(phone)) {
            errorMsg(resp, "Please, input your Phone!");
        }

        if (validationEmail(resp, email)) {
            filterChain.doFilter(req, resp);
        }

        if (StringUtils.isEmpty(address)) {
            errorMsg(resp, "Please, input your Address!");
        }

    }


    private boolean validationEmail(ServletResponse resp, String email) throws IOException {

        if (StringUtils.isEmpty(email)) {
            errorMsg(resp, "Please, input your Email!");
            return false;
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            errorMsg(resp, "Validation for " + email + "not passed.");
            return false;
        }

        return true;
    }

    private void errorMsg(ServletResponse resp, String msg) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(msg);
        writer.flush();
    }

    public void destroy() {

    }
}
