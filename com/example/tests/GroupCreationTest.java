package com.example.tests;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {	
	 
	Random rnd = new Random(); 
	
	@DataProvider(name = "randomGroups")
	public Iterator<Object[]> generateRandomGroups()
	{
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i=0; i<5; i++)
		{
			GroupObject group = new GroupObject().setName("testName"+rnd.nextInt()).
					setHeader("testHeader"+rnd.nextInt()).
					setFooter("testFooter"+rnd.nextInt());
			list.add(new Object []{group});
		}
		return list.iterator();
		
	}

	@Test(dataProvider = "randomGroups")
  public void testValidGruopCanBeCreated(GroupObject validGroup) throws Exception 
  {

		//pre_verification
		Set<GroupObject> oldList= app.getGroupHelper().getGroups();
		
		//action
		app.getGroupHelper().createGroup(validGroup);
		
		
		//verification
		Set<GroupObject> newList = app.getGroupHelper().getGroups();
		verifyGroupAdded(oldList, validGroup, newList);
  }
	
	private void verifyGroupAdded(Set<GroupObject> oldLIst,
			GroupObject validGroup, Set<GroupObject> newList) {
		
		assertThat(newList.size(), equalTo(oldLIst.size()+1));
		validGroup.setId("$$$");
		oldLIst.add(validGroup);
		validGroup.setId(null);
		assertThat(newList, equalTo(oldLIst));
		
	}
  
 
}

/* @Test
public void testValidGruopWithEmptyDataCanBeCreated() throws Exception {
	
	 GroupObject emptyGroup = new GroupObject()
	.setName("")
	.setHeader("")
	.setFooter("");
	
	//pre_verification
	Set<GroupObject> oldList= app.getGroupHelper().getGroups();
	
	//action
	app.getGroupHelper().createGroup(emptyGroup);
	
	
	//verification
	Set<GroupObject> newList = app.getGroupHelper().getGroups();
	verifyGroupAdded(oldList, emptyGroup, newList);
}
*/
