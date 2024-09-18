package com.selenium.practice;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownLoadFiles {

	public static void main(String[] args) throws InterruptedException {
		String fileType = "DOC, DOCX";
		EdgeOptions options = new EdgeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", "C:\\Users\\sandeepdalei\\Music\\testrDownload");
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://file-examples.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text() = 'Sample documents']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[text() = '"+fileType+"']/../td[3]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[starts-with(text() ,'Download sample')]")).click();
		Thread.sleep(10000);
		
		//driver.quit();
	}

}
