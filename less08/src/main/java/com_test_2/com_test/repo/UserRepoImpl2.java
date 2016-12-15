package com_test_2.com_test.repo;

import com_test_2.com_test.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
@Repository(value = "userRepo2")
public class UserRepoImpl2 implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("r2xxx1", 13),
                new User("r2xxx2", 14),
                new User("r2xxx3", 15),
                new User("r2xxx4", 16)
        );
    }

}
