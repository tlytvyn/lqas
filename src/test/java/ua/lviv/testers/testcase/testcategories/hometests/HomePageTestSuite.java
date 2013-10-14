package ua.lviv.testers.testcase.testcategories.hometests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ua.lviv.testers.testcase.testcategories.LoginPageTest;

public class HomePageTestSuite extends LoginPageTest{
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 1.1
	public void enterAdminPageView(){
		Assert.assertTrue(home.isSiteLogoDisplayed());
	}
	
	
	
}
