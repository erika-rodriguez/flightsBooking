import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class LoggingListeners implements ITestListener {
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(LoggingListeners.class));
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Start testing "+result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        LOGGER.info("Testing Process Finished. Methods tested: ");
        for (ITestNGMethod e:context.getAllTestMethods()) {
            LOGGER.info("Testing Process Finished: "+e.getMethodName());
        }

    }

}
