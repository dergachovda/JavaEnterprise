package com.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class AuthFilters implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String name = req.getParameter("login");
        String password = req.getParameter("password");
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(password)) {

//            InputStream resourceAsStream = AuthFilters.class.getClassLoader().
//                    getResourceAsStream("admin.properties");

            InputStream resourceAsStream = AuthFilters.class.getResourceAsStream("admin.properties");

            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String adminLogin = properties.getProperty("login");
            String adminPassword = properties.getProperty("password");

            if (name.equals(adminLogin) && password.equals(adminPassword)) {
                chain.doFilter(req, resp);
            } else {
                errorMsg(resp, "Sorry, you aren't admin user");
            }
        } else {
            errorMsg(resp, "ERROR!!!");
        }
    }

    private void errorMsg(ServletResponse resp, String msg) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(msg);
        writer.flush();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
