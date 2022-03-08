package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;


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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestTablesData 
{
	private WebDriver driver;
	private String url;


	@BeforeMethod
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://demo.guru99.com/test/web-table-element.php";
		driver.navigate().to(url);
		// implicit wait also finds the invisible element with display:none
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}	
	@Test
	public void shouldGetTableValues() throws InterruptedException
	{ 	
		WebElement tableEle = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody"));
		
		List<WebElement> rows = tableEle.findElements(By.tagName("tr"));
		
		System.out.println(rows.size());
		System.out.println("Bank Name \t Current Price");	
		for(WebElement row : rows)
		{
			List<WebElement> cols = row.findElements(By.tagName("td"));
			System.out.print(cols.get(0).getText()+"\t\t\t");
			System.out.println(cols.get(3).getText());
		}
		
		Thread.sleep(2000);
	}
	@AfterMethod
	public  void closeBrowser()
	{
		// 4) close the browser
		//driver.close();
	}
}