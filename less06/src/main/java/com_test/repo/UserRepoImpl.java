package com_test.repo;

import com_test.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepoImpl implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("name1", 11),
                new User("name2", 12),
                new User("name3", 13),
                new User("name4", 14)
        );
    }

}
