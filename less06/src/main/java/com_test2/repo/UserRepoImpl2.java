package com_test2.repo;

import com_test2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo2")
public class UserRepoImpl2 implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("r2_name1", 11),
                new User("r2_name2", 12),
                new User("r2_name3", 13),
                new User("r2_name4", 14)
        );
    }

}
