package com.mphasis.selenium.SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstDemo {

	private static WebDriver driver;
	public static void loadDriver()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/Shalini/Desktop/jars/chromedriver");
		
		// windows user
		//System.setProperty("webdriver.chrome.driver", "D://jars/chromedriver.exe");

		// 2) which browser

		driver = new ChromeDriver();
	}
	public static void openBrowser(String url)
	{
		// 3) open the browser and url
		//driver.get("https://www.techgatha.com");

		// navigate
		driver.navigate().to(url);
	}
	public static void closeBrowser()
	{
		// 4) close the browser
		driver.close();
	}

	public static void navigate()
	{
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		if(title.equals("Google"))
			System.out.println("success");
		
		System.out.println(driver.getPageSource());
	}
	public static void main(String[] args) throws InterruptedException {

		loadDriver();
		openBrowser("https://www.google.com");
		navigate();
		closeBrowser();
	}

}
