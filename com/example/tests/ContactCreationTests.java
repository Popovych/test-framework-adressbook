package com.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	
	@Test 
	public void testContactCreator() throws Exception {
		ContactObject contactObject = new ContactObject( "test1","test2","test3","test4","test5","test2","test1","test2","test1","test2","test1","test2","test1");
		app.getContactHelper().createContact(contactObject);
		
	}
}


