package ua.lviv.testers.testcase.testcategories.logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ua.lviv.testers.pages.enterapp.AdminPage;
import ua.lviv.testers.testcase.testcategories.LoginPageTest;


public class LoginPageTestSuite extends LoginPageTest{
	
	@Test (groups = {"groupLQAS", "all"})
	//TS 1.1
	public void enterAdminPageView(){
		AdminPage admin = login.loginAdminPage(getUsermail(), getPassword());
		Assert.assertTrue(admin.isAdminPageDisplayed());
	}
	
	
	
}
