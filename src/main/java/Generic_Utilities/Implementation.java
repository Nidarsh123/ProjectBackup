package Generic_Utilities;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//program for extendReport
public class Implementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		//we get method name for failure test-cases
		String testData = result.getMethod().getMethodName();
		
		//Taking screenshot for failure test cases and we add (BaseClass1.Sdriver) after BaseClass1 changes
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass1.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+testData+".png"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
	}

	//using for designing outline of the report
	public void onStart(ITestContext context) {

		Random random = new Random();
		int randNum = random.nextInt(1000);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+randNum);
		spark.config().setTheme(Theme.DARK);//outline colour
		spark.config().setDocumentTitle("Testing");//title of document
		spark.config().setReportName("Nidarsh");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("Executed By", "Nidarsh");
		report.setSystemInfo("Reviewed By", "Manager");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
