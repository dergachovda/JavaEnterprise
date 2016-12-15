package custom_runner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Created by BGClassTeacher on 01.12.2016.
 */
public class CustomRunListener extends RunListener {

    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println(description);
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println(result.getRunCount());
    }

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println(description);
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println(description);
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println(failure.getDescription());
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        System.out.println("ASSUM" + failure.getDescription());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println(description);
    }
}
