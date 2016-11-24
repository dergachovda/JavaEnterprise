package com_test;

import com_test.model.User;
import com_test.repo.UserRepo;
import com_test.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        List<User> allUser = userService.getAllUsers();
//        for (User user : allUser) {
//            System.out.println(user);
//        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = context.getBean("userService", UserService.class);
        UserRepo userRepo = context.getBean("userRepo", UserRepo.class);

        System.out.println("userService = " + userService);
        System.out.println("userRepo = " + userRepo);

        List<User> allUser = userService.getAllUsers();
        for (User user : allUser) {
            System.out.println(user);
        }


    }

}
