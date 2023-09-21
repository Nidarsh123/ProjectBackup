package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {

	@Test
	public void CreateCustomerTest()
	{
		System.out.println("step-1");
		System.out.println("step-2");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(true, false);
		System.out.println("step-3");
		System.out.println("step-4");
		soft.assertAll();
		//output is filed because of false
	}
	
	@Test
	public void ModifyCustomerTest()
	{
		String expData = "Qspider";
		String actData = "Qspider";
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expData, actData);
		soft.assertAll();
		//output is passed
	}
}
