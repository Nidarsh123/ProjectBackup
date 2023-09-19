package Practice;

import org.testng.annotations.Test;

//not run successfully
public class SoftAssert {

	@Test
	public void createCustomerTest()
	{
		System.out.println("step-1");
		System.out.println("step-2");
		SoftAssert s = new SoftAssert();
		s.assertEqual("A","B");
		System.out.println("step-3");
		s.assertEqual("X","Y");
		System.out.println("step-4");
		s.assertAll();	
	}
	
	private void assertAll() {
		// TODO Auto-generated method stub
		
	}

	private void assertEqual(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void modifyCustomerTest()
	{
		System.out.println("-----------------------");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
