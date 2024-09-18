package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCHk {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.nytimes.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		/*
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//span[text() = 'Log in']")).click();
		 */
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("(//li[@data-testid = 'nav-item-U.S.']/a)[2]"))).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//ul[@aria-labelledby = 'U.S.-links-column-header']/li/a[text() = 'U.S.'])[2]")).click();
	}

}
