package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AssertionsPractice {

	@Test
	public void practice()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(true, true); //condition pass - act = exp
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step 1 - practice");
		Assert.assertEquals("A", "c");//pass
		
		System.out.println("step 2 - practice");
		Assert.assertEquals("A", "w");//pass
		
		//sa.assertTrue(true);
		//sa.assertEquals("A", "b"); //failed
		
		
		System.out.println("step 3 - practice");
		sa.assertTrue(false);//fail---
		System.out.println("step 4 - practice");
		Assert.assertEquals("A", "b"); 
		sa.assertAll();
	}
}
