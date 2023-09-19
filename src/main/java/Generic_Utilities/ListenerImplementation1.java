package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation1 implements ITestListener {

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
	}

