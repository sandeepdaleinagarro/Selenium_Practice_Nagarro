package com.selenium.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalendar {

	public static void main(String[] args) throws ParseException, InterruptedException {

		/*
		 * Date date1 = Calendar.getInstance().getTime(); System.out.println(date1);
		 * System.out.println(new SimpleDateFormat("yyyyMMMMMdd").format(date1));
		 */

		String targetDate = "29-04-2020";
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(targetDate);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.id("second_date_picker")).click();
		//Thread.sleep(5000);

		String monthYr = driver.findElement(By.className("ui-datepicker-title")).getText();//July 2023
		calendar.setTime(new SimpleDateFormat("MMMM yyyy").parse(monthYr));

		int actualMonth = calendar.get(Calendar.MONTH);
		int actualYear = calendar.get(Calendar.YEAR);

		while(targetMonth < actualMonth || targetYear < actualYear) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Prev']"))); 
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			monthYr = driver.findElement(By.className("ui-datepicker-title")).getText();//July 2023
			calendar.setTime(new SimpleDateFormat("MMMM yyyy").parse(monthYr));

			actualMonth = calendar.get(Calendar.MONTH);
			actualYear = calendar.get(Calendar.YEAR);
		}

		//Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class = 'ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text() = "+targetDay+"]")).click();
	}

}
