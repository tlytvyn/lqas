package ua.lviv.testers.testcase.testcategories;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ua.lviv.testers.testcase.TestBase;



public class LoginPageTest extends TestBase{
	
	
	@BeforeMethod (groups = {"groupLQAS", "all"})
	public void testInit() throws Exception {
		
	}
	
	@AfterMethod(alwaysRun = true, groups = {"groupLQAS", "all"})
    public void afterClass() throws Exception {
		
    }
}
