package com.example.fv;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;




import org.openqa.selenium.WebElement;

import com.example.tests.GroupObject;

public class GroupHelper extends HelperWithWebDriverBase {
	

	public GroupHelper(ApplicationManager manager)
	{
		super(manager);
	}
	
	public Set<GroupObject> getGroups() {
		
		manager.getNavigationHelper().goToGroupListPage();
		
		WebElement form = findElements(By.tagName("form")).get(1);//находим нужную нам форму
		List <WebElement> checkboxes = form.findElements(By.name("selected[]"));// создаем список который включает каждый элемент формы
		Set <GroupObject> groups = new HashSet<GroupObject>();// нах эта строка? пустой контейнер для зписи всех груп со страници
		
		for (WebElement checkbox: checkboxes)
		{
			String title = checkbox.getAttribute("title");
			//работа со строками
			title = title.substring("select (".length(),title.length()-")".length());
			//
			GroupObject group = new GroupObject().setName(title).setId(checkbox.getAttribute("value"));
			groups.add(group);
		}
		return groups;
	}

	public void createGroup(GroupObject validGroup) {
	    manager.getNavigationHelper().goToGroupListPage();
	    
	    initGroupCreation();
		fillGroupForm(validGroup);
	    submitGroupCreation();
	    returnToGroupListPage();
	}
	
	public void deleteGroup(int i) {
		manager.getNavigationHelper().goToGroupListPage();
		//click(By.name("groups"));
		checkGroup(i);
		initGroupDelete();
		returnToGroupListPage();
	}

	private void initGroupDelete() {
		click(By.name("delete"));
	}

	
	
	public void modifyGroup(int i, GroupObject groupObject) {
		manager.getNavigationHelper().goToGroupListPage();
		
		initGroupModification(i);
		fillGroupForm(groupObject);
	    submitGroupModification();
	    returnToGroupListPage();
	}	
	
	

	private void checkGroup(int i) {
		click(By.name("selected[]"));
	}

	private void initGroupCreation() {
		click(By.name("new"));
	}
	
	private void initGroupModification(int i) {
		checkGroup(i);
		click(By.name("edit"));	
	}
	
	private void fillGroupForm(GroupObject groupObject) {
		type(groupObject.name, "group_name");
		type(groupObject.header,"group_header");
		type(groupObject.footer,"group_footer");
	}
	
	private void submitGroupCreation() {
		click(By.name("submit"));
	}
	
	private void submitGroupModification() {
		click(By.name("update"));
		
	}

	private void returnToGroupListPage() {
		click(By.linkText("group page"));
	}
	
}
