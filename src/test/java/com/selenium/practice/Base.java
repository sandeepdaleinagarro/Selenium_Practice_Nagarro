package com.selenium.practice;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class Base {
	
	public WebDriver driver;
	
	public void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://google.com");
	}
	
	public void takeScreenShot() throws WebDriverException, IOException {
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./images/image"+RandomString.make(3)+".png"));
	}
	
	public void tearDown() {
		driver.quit();
	}

}
