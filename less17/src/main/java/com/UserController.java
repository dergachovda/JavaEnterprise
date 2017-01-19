package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users") // <host>/<web-context>/users
public class UserController {

    List<User> users = new ArrayList<User>(Arrays.asList(
            new User(1, "name1", 12),
            new User(2, "name2", 14),
            new User(3, "name3", 13)
    ));

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getFirstPage() {
        throw new NullPointerException();
//        return "user_page";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return users;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody List<User> setUser(@RequestBody User user) {
        users.add(user);
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody List<User> updateUser(@PathVariable("id") int id, @RequestBody User newUser) {
        for (User user : users) {
            if(user.getId() == id) {
                user.merge(newUser);
                break;
            }
        }
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody User GetUserById(@PathVariable("id") int id) {
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
