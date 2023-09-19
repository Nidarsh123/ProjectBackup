package Practice;

import org.testng.annotations.Test;

public class TestNgclass1 {
	
	@Test(enabled=true)
	public void CreatedProductName()
	{
		System.out.println("ProdName Created");
	}
	
	@Test(priority=-1)
	public void ModifyProductName()
	{
		System.out.println("ProdName Modify");
	}
	
	@Test(invocationCount = 4)
	public void DeleteProdName()
	{
		System.out.println("ProdName Delete");
	}
}
