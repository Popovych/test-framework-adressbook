package com.example.fv;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperWithWebDriverBase {
	
	public NavigationHelper(ApplicationManager manager)
	{
		super(manager);
	}
	
	public void openMainPage() {
		//if (we are not on main page)
		openUrl("http://127.0.0.1/addressbookv4.1.4/");
	}

	public void goToGroupListPage() {
		//if(findElement(By.tagName("h1")))
		click(By.linkText("groups"));
	}


	public void goToCreateContactPage() {
		//if(findElement(By.tagName("h1")))
		click(By.linkText("add new"));
	}
	
	public void goToHomePage() {
		click(By.linkText("home page"));
		}
}
