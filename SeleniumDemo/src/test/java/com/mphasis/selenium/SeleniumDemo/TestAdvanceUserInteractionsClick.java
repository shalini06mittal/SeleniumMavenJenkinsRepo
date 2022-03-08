package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAdvanceUserInteractionsClick 
{
	private WebDriver driver;
	private String url;
	
	// screenshots and advance actions 
	// testng

		@BeforeEach
		public void before()
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
			driver = new ChromeDriver();
			url = "https://www.techgatha.com/contact.html";
			driver.navigate().to(url);
			// implicit wait also finds the invisible element with display:none
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}	
	    @Test
	    public void shouldSendKeysToTectBox() throws InterruptedException
	    { 	
			WebElement ele = driver.findElement(By.id("name"));
			
			Actions builder = new Actions(driver);
			// will perform mouse over action
			Action seriesOfActions = builder.moveToElement(ele)
					.click()
					.pause(Duration.ofSeconds(2))
					.keyDown(ele, Keys.SHIFT)
					.sendKeys("shalini")
					.pause(Duration.ofSeconds(2))
					.keyUp(ele, Keys.SHIFT)
					.doubleClick(ele)
					.pause(Duration.ofSeconds(2))
					.contextClick()
					.pause(Duration.ofSeconds(2))
					
					.build();
			
			
			seriesOfActions.perform();
			
			builder.sendKeys(Keys.DOWN).build().perform();
			builder.sendKeys(Keys.DOWN).build().perform();
			builder.sendKeys(Keys.ENTER).build().perform();
//			driver.findElement(By.linkText("Copy")).click();
//			
//			Thread.sleep(1000);
//			WebElement ele1 = driver.findElement(By.id("email"));
//			builder.moveToElement(ele1)
//			.click()
//			.pause(Duration.ofSeconds(2))
//			.keyDown(ele, Keys.CONTROL)
//			.sendKeys("V")
//			.pause(Duration.ofSeconds(2))
//			.keyUp(ele, Keys.CONTROL)
//			
//			.pause(Duration.ofSeconds(2))
//			.build().perform();
//	
			
			Thread.sleep(2000);
	    }
	    @AfterEach
		public  void closeBrowser()
		{
			// 4) close the browser
			driver.close();
		}
}