package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSwitchBetweenWindows {
	private WebDriver driver;
	private String url;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		driver = new ChromeDriver();
		url = "https://www.techgatha.com";
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@Test
	public void testByLinkTextStrategy() throws InterruptedException {
		
		WebElement kidsEle = driver.findElement(By.partialLinkText("Kids".toUpperCase()));
		kidsEle.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement anchorEle = driver.findElement(By.xpath("//*[@id=\"creations\"]/div[3]/div[1]/div/a"));
		anchorEle.click();
		// saves the reference of the main window 
		String mainWindow = driver.getWindowHandle();
		System.out.println("mainWindow "+mainWindow);
		// get the set of all the windows opened by the driver
		Set<String> windows = driver.getWindowHandles();
		// bget the iterator
		Iterator<String> it = windows.iterator();
		// iterate and check for next window
		while(it.hasNext())
		{
			String cw1 = it.next();
			System.out.println("cw1 "+cw1);
			if( ! mainWindow.equalsIgnoreCase(cw1))
			{
				driver.switchTo().window(cw1);
				driver.findElement(By.linkText("Funeral Flowers")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("a[href='Funeral.html'")).click();
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
	}
}
