package com_test_2.com_test.repo;

import com_test_2.com_test.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 24.11.2016.
 */
@Repository(value = "userRepo1")
public class UserRepoImpl implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("repo1 xxx1", 13),
                new User("repo1 xxx2", 14),
                new User("repo1 xxx3", 15),
                new User("repo1 xxx4", 16)
        );
    }

}
