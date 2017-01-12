package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getFirstPage() {
        return "first"; //page webapp\WEB-INF\pages\first.jsp
    }
}
