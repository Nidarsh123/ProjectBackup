package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//test script is true execute in 1 time or false it execute 3 times
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryLimit=3;//2,1
	public boolean retry(ITestResult result) {
		
		if(count<retryLimit){
			
			count++;
			return true;
		}
		return false;
	}

}
