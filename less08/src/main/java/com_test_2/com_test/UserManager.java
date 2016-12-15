package com_test_2.com_test;

import com_test_2.com_test.model.User;
import com_test_2.com_test.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
public class UserManager {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        List<User> allUsers = userService.getAllUsers();
//        for(User user : allUsers){
//            System.out.println(user);
//        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation-context.xml");
        UserService userService = context.getBean("userService", UserService.class);
       // UserRepo userRepo = context.getBean("userRepo", UserRepo.class);

        System.out.println(userService);
       // System.out.println(userRepo);


        List<User> allUsers = userService.getAllUsers();
        for(User user : allUsers){
            System.out.println(user);
        }
    }
}
