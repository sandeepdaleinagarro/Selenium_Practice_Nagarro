package com.selenium.practice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListnerITest.class)
public class TakeScreenSHotforFailedTest {
	
	Base base = new Base();
	
	@BeforeMethod
	public void before() {
		base.setDriver();
	}
	
	
	@Test
	public void check() {
		Assert.assertEquals(true, true);;
	}
	
	@AfterMethod
	public void after() {
		base.tearDown();
	}

}
