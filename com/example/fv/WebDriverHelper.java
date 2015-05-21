package com.example.fv;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {

	public static WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private final ApplicationManager manager;
	
	
	
	public WebDriverHelper(ApplicationManager manager)
	{
		this.manager = manager;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1/addressbookv4.1.4/");
	}

	public void stop()
	{  driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) 
    {
      fail(verificationErrorString);
    }		
	}

	public WebDriver getDriver()
	{
		return  driver;
	}
	
}
