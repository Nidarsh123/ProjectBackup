package Practice;

import org.testng.annotations.Test;

public class TestNgClass2 {
	@Test
	public void CreatedProductName()
	{
		//enable = false;(independent false then CreateProductName and ModifyProductName will skipped)
		System.out.println("ProdName Created");
	}
	
	@Test(dependsOnMethods = "CreatedProductName")
	public void ModifyProductName()
	{
		System.out.println("ProdName Modify");
	}
	
	@Test
	public void DeleteProdName()
	{
		System.out.println("ProdName Delete");
	}
}
