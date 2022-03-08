package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScreenShot 
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
			url = "https://www.techgatha.com";
			driver.navigate().to(url);
			// implicit wait also finds the invisible element with display:none
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}	
	    @Test
	    public void shouldAllowScreenShot() throws InterruptedException, IOException
	    { 	
			WebElement ele = driver.findElement(By.partialLinkText("SER"));
			
			ele.click();
			
			TakesScreenshot tks = (TakesScreenshot)driver;
			File srcfile = tks.getScreenshotAs(OutputType.FILE);
			File destFile = new File("ser.png");
			
			FileUtils.copyFile(srcfile, destFile);
			
			Thread.sleep(2000);
	    }
	    @AfterEach
		public  void closeBrowser()
		{
			// 4) close the browser
			driver.close();
		}
}