package com.example.fv;

import java.util.Set;

import org.openqa.selenium.By;

import com.example.tests.ContactObject;
import com.example.tests.GroupObject;

public class ContactHelper extends HelperWithWebDriverBase {
	
	public void createContact(ContactObject validContact) {
	  
		manager.getNavigationHelper().goToCreateContactPage();
	    
		fillContactForm(validContact);
		
		submitContactCreation();
	    
		manager.getNavigationHelper().goToHomePage();
	}
	
	public ContactHelper(ApplicationManager manager)
	{
		super(manager);
	}
	

	private void fillContactForm (ContactObject validContact) {
		
		
		type(validContact.inputText1, "firstname");
		type(validContact.inputText2, "lastname");
		type(validContact.inputText3, "address");
		type(validContact.inputText4, "home");
		type(validContact.inputText5, "mobile");
		type(validContact.inputText6, "work");
		type(validContact.inputText7, "email");
		type(validContact.inputText8, "email2");
		selectFromDropdown (3, "bday");
		selectFromDropdown (3, "bmonth");	
		type(validContact.inputText9, "bday");
		type(validContact.inputText10, "bmonth");
		type(validContact.inputText11, "byear");
		type(validContact.inputText12, "address2");
		type(validContact.inputText13, "phone2");

	}
	
private void submitContactCreation() {
		
		click(By.name("submit"));
	}



}
