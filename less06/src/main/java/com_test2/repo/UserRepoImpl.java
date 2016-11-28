package com_test2.repo;

import com_test2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo")
public class UserRepoImpl implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("r1_name1", 11),
                new User("r1_name2", 12),
                new User("r1_name3", 13),
                new User("r1_name4", 14)
        );
    }

}
