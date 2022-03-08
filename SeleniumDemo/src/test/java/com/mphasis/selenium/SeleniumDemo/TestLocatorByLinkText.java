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

public class TestLocatorByLinkText {
	private WebDriver driver;
	private String url;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://code.org";
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	//done?
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void testByLinkTextStrategy() throws InterruptedException {
		
		driver.findElement(By.className("close")).click();
		
		WebElement linkLearn = driver.findElement(By.linkText("Learn"));
		linkLearn.click();
		Thread.sleep(1000);
		
		WebElement linkTeach = driver.findElement(By.linkText("Teach"));
		linkTeach.click();
		Thread.sleep(300);
		
		WebElement linkProjects = driver.findElement(By.linkText("Projects"));
		linkProjects.click();
		Thread.sleep(300);
		
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		String actualTitle = driver.getTitle();
		String expected = "Learn Computer";
		
		assertTrue(actualTitle.contains(expected));
		Thread.sleep(1000);
		
	}
}
