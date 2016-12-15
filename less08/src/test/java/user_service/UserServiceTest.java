package user_service;

import com_test.model.User;
import com_test.service.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Ignore
@RunWith(JUnit4.class)
public class UserServiceTest {
    static UserService userService;

    @BeforeClass
    public static void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = context.getBean("userService", UserService.class);
    }

    @Test
    public void get_all_users_test(){
        List<User> allUsers = userService.getAllUsers();
        Assert.assertEquals(allUsers.size(), 4);
    }

}
