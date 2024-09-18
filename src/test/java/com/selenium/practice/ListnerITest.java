package com.selenium.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerITest extends Base implements ITestListener{
	
	public void onTestFailure(ITestResult result)
	{
		try {
			takeScreenShot();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
