package com.example.fv;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperWithWebDriverBase {
	
	protected final ApplicationManager manager;
	private WebDriver driver;
	
	public HelperWithWebDriverBase(ApplicationManager manager)
	{
		this.manager = manager;
		driver = manager.getWebDriverHelper().getDriver();
	}
	protected void type(String inputText1, String locator) {
		//driver.findElement(By.name(locator)).clear();
	    driver.findElement(By.name(locator)).sendKeys(inputText1);
	}
	protected void selectFromDropdown(int dropdownIndex, String locator) {
		Select dropdown = new Select(driver.findElement(By.name(locator)));
	    dropdown.selectByIndex(dropdownIndex);
	}
	
	protected WebElement findElement(By linkText) {
		return driver.findElement(linkText);
	}
	
	protected List<WebElement> findElements(By linkText) {
		return driver.findElements(linkText);
	}
	
	protected void openUrl(String string) {
		driver.get(string);
	}
	protected void click(By linkText) {
		findElement(linkText).click();
	}

}
