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

public class TestLocatorByXPath {
	private WebDriver driver;
	private String url;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://accounts.lambdatest.com/register/?_gl=1*1mvexe0*_gcl_aw*R0NMLjE2NDYxOTI2OTIuQ2p3S0NBaUFwZmVRQmhBVUVpd0E3S19VSF9Jb0hEU19PZzZRWFFwbEJOUXd0aUktNnNCQk1zOUI5dm8zbFR5UEVqdWlfeVVYQjAzZGVob0NMLWNRQXZEX0J3RQ..";
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	@Test
	public void testByLinkTextStrategy() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/div/a[1]"));
		ele.click();
		Thread.sleep(3000);
		
	}
}
