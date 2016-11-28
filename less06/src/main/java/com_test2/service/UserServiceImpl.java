package com_test2.service;

import com_test2.model.User;
import com_test2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value = "userRepo2")
//    private UserRepo userRepo;

    @Resource
    @Qualifier(value = "userRepo2")
    private UserRepo userRepo;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
