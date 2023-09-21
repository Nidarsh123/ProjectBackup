package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert1 {

	@Test
	public void CreateCustomerTest()
	{
		System.out.println("step-1");
		String ExpData = "Qspider";
		String ActData = "qspider";
		Assert.assertEquals(ExpData, ActData);
		System.out.println("step-2");
		System.out.println("step-3");
		//output is failed and generate step-1
	}
	
	@Test
	public void ModifyCreteCustomerTest()
	{
		System.out.println("step-4");
		Assert.assertEquals(true, true);
		//output pass and generate step-4
	}
}
