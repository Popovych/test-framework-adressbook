package com.example.fv;


public class ApplicationManager {

	private static ApplicationManager singleton;
	private WebDriverHelper webDriverHelper;
	private GroupHelper groupHelper;
	private NavigationHelper navigationHelper;
	private ContactHelper contactHelper;
	
	public static ApplicationManager getInstance() {
		if (singleton == null) { 
			singleton = new ApplicationManager(); 
			}
		return singleton;
	}
	
	public void stop(){
		if (webDriverHelper != null){
		webDriverHelper.stop();
		}
	};

	
	public WebDriverHelper getWebDriverHelper() {
		if ( webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper(this);
		}
		return webDriverHelper;
		
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}

	

	public NavigationHelper getNavigationHelper() {
		if (navigationHelper == null){
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper == null){
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

}
