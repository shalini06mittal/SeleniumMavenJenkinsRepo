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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAdvanceUserInteractions 
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
	    public void shouldColorAfterHoverBeAsExpected() throws InterruptedException
	    { 	
			WebElement ele = driver.findElement(By.partialLinkText("KIDS"));
			
			Actions builder = new Actions(driver);
			// will perform mouse over action
			Action actionHover = builder.moveToElement(ele).build();
			
			String color = ele.getCssValue("color");
			System.out.println(ele.getText());
			System.out.println("Before Hover "+Color.fromString(color).asHex());
			Thread.sleep(2000);
			
			actionHover.perform();
			color = ele.getCssValue("color");
			System.out.println("After Hover "+Color.fromString(color).asHex()+" "+color);
			Thread.sleep(2000);
	    }
	    @AfterEach
		public  void closeBrowser()
		{
			// 4) close the browser
			driver.close();
		}
}