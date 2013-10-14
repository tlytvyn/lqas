package ua.lviv.testers.testcase.testcategories.logintests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ua.lviv.testers.pages.enterapp.LoginPage;
import ua.lviv.testers.testcase.testcategories.LoginPageTest;


public class LoginPageTestSuite extends LoginPageTest{
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 2.1
	public void enterAdminPageView() throws InterruptedException{
		LoginPage login = home.loginAdminPage(getUsermail(), getPassword());
		//Thread.sleep(4000); to see that it works
		Assert.assertTrue(login.isAvatarDisplayed());
	}
	
	
	
}
