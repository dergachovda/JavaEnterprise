package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_service.UserServiceTest;
import user_service.UserServiceTest2;

/**
 * Created by BGClassTeacher on 01.12.2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UserServiceTest.class, UserServiceTest2.class })
public class UserSuiteTest {


}
