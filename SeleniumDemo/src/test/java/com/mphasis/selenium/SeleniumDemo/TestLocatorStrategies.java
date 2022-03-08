package com.mphasis.selenium.SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLocatorStrategies {

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
	public void testFindById() throws InterruptedException {
		
		
		WebElement nameEle = driver.findElement(By.id("firstName"));
		System.out.println(nameEle.getTagName());
		
		nameEle.sendKeys("Shalini");
		
		WebElement lastnameEle = driver.findElement(By.id("lastName"));
		lastnameEle.sendKeys("Mittal");
		
		WebElement emailele = driver.findElement(By.id("userEmail"));
		emailele.sendKeys("shalini@gmail.com");
		
		//Thread.sleep(1000);
		
		WebElement radioMale = driver.findElement(By.id("gender-radio-1"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", radioMale);
		
		WebElement phoneele = driver.findElement(By.id("userNumber"));
		phoneele.sendKeys("1212121212");
		
		WebElement date = driver.findElement(By.id("dateOfBirthInput"));
		date.sendKeys("05 Feb 2000");
		
		date.sendKeys(Keys.ESCAPE);
		
		driver.findElement(By.id("subjectsInput")).sendKeys("xyz");

		//Thread.sleep(1000);
		
		WebElement chkbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
		//chkbox1.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", chkbox1);
		Thread.sleep(3000);
		
		js.executeScript("window.scroll(0,380)");
		
		WebElement fileele = driver.findElement(By.id("uploadPicture"));
		System.out.println(fileele.getAttribute("type"));// auto-it tool
		
		fileele.sendKeys("/Users/Shalini/Desktop/hello.html");

		
		//		//hobbies-checkbox-1
//		//fileele.click();
//		js.executeScript("arguments[0].click()", fileele);
		Thread.sleep(1000);
		
	}
	

}
