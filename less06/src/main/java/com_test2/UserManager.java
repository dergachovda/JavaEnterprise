package com_test2;

import com_test2.model.User;
import com_test2.repo.UserRepo;
import com_test2.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        List<User> allUser = userService.getAllUsers();
//        for (User user : allUser) {
//            System.out.println(user);
//        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation-context.xml");
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
