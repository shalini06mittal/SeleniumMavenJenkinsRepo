package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWaitTimeOuts 
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
			url = "https://the-internet.herokuapp.com/dynamic_loading/1";
			driver.navigate().to(url);
			// implicit wait also finds the invisible element with display:none
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}	
	    @Test
	    public void shouldTitleMatch() throws InterruptedException
	    { 	
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
			ele.click();
			
			
			WebDriverWait waitdriver = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitdriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
			
			WebElement eleText = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
			assertEquals(eleText.getText(), "Hello World!");
			Thread.sleep(2000);
	    }
	    @AfterEach
		public  void closeBrowser()
		{
			// 4) close the browser
			driver.close();
		}
}