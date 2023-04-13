package com.amazon.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserAppLaunch {
	WebDriver driver;
	
	public static WebDriver launchBrowser(WebDriver driver,String browser,String appUrl)
	{
		if(browser.equals("Chrome")) 
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/drivers/win_chromedriver_111.exe");
		//System.getProperty("user.dir")
		driver=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./IEDriver.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		//driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.quit();		
		return driver;
	}

	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
