package com_test.service;

import com_test.model.User;
import com_test.repo.UserRepo;

import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
public class UserServiceImpl implements UserService {
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
