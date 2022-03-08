package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLocatorByCssSelector {
	private WebDriver driver;
	private String url;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://demoqa.com/automation-practice-form";
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void testByLinkTextStrategy() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.cssSelector("input[id^=first]"));
		ele.sendKeys("Mphasis");
		Thread.sleep(3000);
		
	}
}
