package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLocatorForFrames {
	private WebDriver driver;
	private String url;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://docs.oracle.com/javase/7/docs/api/";
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void testByLinkTextStrategy() throws InterruptedException {
		
		driver.switchTo().frame("classFrame");
		
		WebElement ele = driver.findElement(By.linkText("Deprecated"));
		ele.click();
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5) );
		
		WebElement headingEle = driver.findElement(By.className("title"));
		
		//assertTrue(headingEle != null);
		Thread.sleep(2000);
	}
}
