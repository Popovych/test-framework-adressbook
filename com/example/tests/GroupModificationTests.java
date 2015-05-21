package com.example.tests;


import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	 @Test
	  public void testFirstGroupCanBeRemoved() throws Exception {
		 GroupObject validGroup = new GroupObject().setName("modified")
					.setHeader("modified")
					.setFooter("modified");;
		app.getGroupHelper().modifyGroup(0, validGroup);
	  }
  
 
}
