package com;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class GlobalInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = Logger.getLogger(GlobalInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("time", System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = Long.parseLong(request.getAttribute("time").toString());
        long startTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(startTime);
        long endTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

        logger.info("time of execution=" + (endTimeInSeconds - startTimeInSeconds));

        super.afterCompletion(request, response, handler, ex);
    }
}
