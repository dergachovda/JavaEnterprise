package com_test_2.com_test.service;

import com_test_2.com_test.model.User;
import com_test_2.com_test.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value = "userRepo1")
//    private UserRepo userRepo2;

    @Resource
    @Qualifier(value = "userRepo1")
    private UserRepo userRepo2;


    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo2 = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo2.getAllUsers();
    }

    public void setUserRepo2(UserRepo userRepo2) {
        this.userRepo2 = userRepo2;
    }

    public UserRepo getUserRepo2() {
        return userRepo2;
    }
}
