package com_test.repo;

import com_test.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
public class UserRepoImpl implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("xxx1", 13),
                new User("xxx2", 14),
                new User("xxx3", 15),
                new User("xxx4", 16)
        );
    }

}
