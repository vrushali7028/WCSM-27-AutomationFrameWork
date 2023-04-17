package vtiger.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implementation for the ItestListener Interface of TestNg 
 * @author patil
 *
 */
public class Listneresimplimentation implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script execution started ===");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script passed ===");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script failed ===");
		System.out.println(result.getThrowable());
		
		WebDriverUtility wutil = new WebDriverUtility();
		String screenshotName = methodName+"-"+new JavaUtility().getSystemDateInFormat();
		try {
			wutil.takeScreenshot(BaseClass.sDriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=== test script skipped ===");
		System.out.println(result.getThrowable());	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=== execution started ===");
		
		new ExtentSparkRepo
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=== execution finished ===");
	}
    
	 
}
