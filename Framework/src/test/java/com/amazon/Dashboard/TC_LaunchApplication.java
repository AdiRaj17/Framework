package com.amazon.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.Common.BrowserAppLaunch;


public class TC_LaunchApplication {

	WebDriver driver;
	@Test	
	public void navigateApplication()
	{
				
		driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://www.amazon.in/");
		System.out.println(driver.getTitle());		
		BrowserAppLaunch.quitBrowser(driver);
	}
			
}
